/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package fr.smile.training.faq.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.base.FaqLocalServiceBaseImpl;
import fr.smile.training.faq.validation.FaqValidator;

/**
 * The implementation of the faq local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>fr.smile.training.faq.service.FaqLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FaqLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=fr.smile.training.faq.model.Faq",
		service = AopService.class
		)
public class FaqLocalServiceImpl extends FaqLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>fr.smile.training.faq.service.FaqLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>fr.smile.training.faq.service.FaqLocalServiceUtil</code>.
	 */

	/**
	 * Adds an faq.
	 * 
	 * @param groupId
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
			type = IndexableType.REINDEX
			)
	public Faq addFaq(
			long groupId, Map<Locale, String> titleMap, String description, ServiceContext serviceContext)
					throws PortalException {

		// Validate faq parameters.

		FaqValidator.validate(titleMap, description);

		// Get group and same time validate that it exists.

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the faq.

		long faqId =
				counterLocalService.increment(Faq.class.getName());

		// Create faq.

		Faq faq = createFaq(faqId);

		// Fill the faq

		faq.setCompanyId(group.getCompanyId());
		faq.setGroupId(groupId);
		faq.setUserId(userId);
		faq.setTitleMap(titleMap);
		faq.setDescription(description);
		faq.setStatus(WorkflowConstants.STATUS_DRAFT);
		faq.setStatusByUserId(userId);
		faq.setStatusByUserName(user.getFullName());
		faq.setStatusDate(serviceContext.getModifiedDate(null));
		faq.setUserName(user.getScreenName());

		faq.setCreateDate(serviceContext.getCreateDate(new Date()));
		faq.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		// Persist faq.

		faq = super.addFaq(faq);

		// Add permission resources.

		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;

		resourceLocalService.addResources(
				group.getCompanyId(), groupId, userId, Faq.class.getName(),
				faq.getFaqId(), portletActions, addGroupPermissions,
				addGuestPermissions);


		// Update asset.

		updateAsset(faq, serviceContext);

		// Start workflow instance and return the faq.

		return startWorkflowInstance(userId, faq, serviceContext);

	}

	/**
	 * Updates asset model related asset.
	 * 
	 * @param faq
	 * @param serviceContext
	 * @throws PortalException
	 */
	private void updateAsset(
			Faq faq, ServiceContext serviceContext)
					throws PortalException {

		assetEntryLocalService.updateEntry(
				serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				faq.getCreateDate(), faq.getModifiedDate(),
				Faq.class.getName(), faq.getFaqId(),
				faq.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				faq.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML,
				faq.getTitle(serviceContext.getLocale()),
				faq.getDescription(), null, null, null, 0, 0,
				serviceContext.getAssetPriority());
	}	

	/**
	 * Starts model workflow instance.
	 * 
	 * @param userId
	 * @param faq
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	protected Faq startWorkflowInstance(
			long userId, Faq faq, ServiceContext serviceContext)
					throws PortalException {

		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();

		String userPortraitURL = "";
		String userURL = "";

		if (serviceContext.getThemeDisplay() != null) {
			User user = userLocalService.getUser(userId);

			userPortraitURL =
					user.getPortraitURL(serviceContext.getThemeDisplay());
			userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
		}

		workflowContext.put(
				WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
		workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

		return WorkflowHandlerRegistryUtil.startWorkflowInstance(
				faq.getCompanyId(), faq.getGroupId(), userId,
				Faq.class.getName(), faq.getFaqId(),
				faq, serviceContext, workflowContext);
	}

	/**
	 * Updates model's workflow status.
	 * 
	 * @param userId
	 * @param faqId
	 * @param status
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Faq updateStatus(
			long userId, long faqId, int status,
			ServiceContext serviceContext)
					throws PortalException, SystemException {

		User user = userLocalService.getUser(userId);
		Faq faq = getFaq(faqId);

		faq.setStatus(status);
		faq.setStatusByUserId(userId);
		faq.setStatusByUserName(user.getFullName());
		faq.setStatusDate(new Date());

		faqPersistence.update(faq);

		if (status == WorkflowConstants.STATUS_APPROVED) {

			assetEntryLocalService.updateVisible(
					Faq.class.getName(), faqId, true);

		}
		else {

			assetEntryLocalService.updateVisible(
					Faq.class.getName(), faqId, false);
		}

		return faq;
	}

	/**
	 * Updates faq.
	 * 
	 * @param faqId
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	@Indexable(
			type = IndexableType.REINDEX
			)
	public Faq updateFaq(
			long faqId, Map<Locale, String> titleMap, String description, ServiceContext serviceContext)
					throws PortalException {

		// Validate faq values
		FaqValidator.validate(titleMap, description);

		// Get Faq

		Faq faq = getFaq(faqId);

		// Update the changes to faq

		faq.setModifiedDate(new Date());
		faq.setTitleMap(titleMap);
		faq.setDescription(description);

		faq = super.updateFaq(faq);

		updateAsset(faq, serviceContext);

		return faq;
	}

	@Indexable(
			type = IndexableType.DELETE
			)
	public Faq deleteFaq(long faqId)
			throws PortalException {

		Faq faq = getFaq(faqId);

		return deleteFaq(faq);
	}

	/**
	 * Deletes faq.
	 * 
	 * @param faq
	 * @return
	 * @throws PortalException 
	 */
	@Indexable(
			type = IndexableType.DELETE
			)
	public Faq deleteFaq(Faq faq) throws PortalException {

		// Delete permission resources.
		resourceLocalService.deleteResource(
				faq, ResourceConstants.SCOPE_INDIVIDUAL);

		// Delete asset data.
		assetEntryLocalService.deleteEntry(
				Faq.class.getName(), faq.getFaqId());

		// Delete workflow instance.
		workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(
				faq.getCompanyId(), faq.getGroupId(),
				Faq.class.getName(), faq.getFaqId());

		// Delete the Faq
		return super.deleteFaq(faq);
	}

	/**
	 * Gets faqs by keywords and status.
	 * 
	 * This example uses dynamic queries.
	 * 
	 * @param groupId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param status
	 * @param orderByComparator
	 * @return
	 */
	public List<Faq> getFaqsByKeywords(
			long groupId, String keywords, int start, int end, int status,
			OrderByComparator<Faq> orderByComparator) {

		//https://portal.liferay.dev/docs/7-2/appdev/-/knowledge_base/a/dynamic-query
		DynamicQuery faqQuery =
				dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (status != WorkflowConstants.STATUS_ANY) {
			faqQuery.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
					RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like(
							"description", "%" + keywords + "%"));
			faqQuery.add(disjunctionQuery);
		}

		return faqLocalService.dynamicQuery(
				faqQuery, start, end, orderByComparator);
	}

	public List<Faq> getFaqsByStatus(int status) {

		return faqPersistence.findByStatus(status);
	}


	public int getFaqsCountByGroupId(long groupId) {

		return faqPersistence.countByGroupId(groupId);
	}

	/**
	 * Get faq count by keywords and status.
	 * 
	 * This example uses dynamic queries.
	 * 
	 * @param groupId
	 * @param keywords
	 * @param status
	 * @return
	 */
	public long getFaqsCountByKeywords(
			long groupId, String keywords, int status) {

		DynamicQuery faqQuery =
				dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (status != WorkflowConstants.STATUS_ANY) {
			faqQuery.add(RestrictionsFactoryUtil.eq("status", status));
		}

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
					RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(
					RestrictionsFactoryUtil.like(
							"description", "%" + keywords + "%"));
			faqQuery.add(disjunctionQuery);
		}

		return faqLocalService.dynamicQueryCount(faqQuery);
	}

	/**
	 * Adds an faq (silenced)
	 * 
	 * This is an example how to "silence" generated method.
	 * 
	 * @param faq
	 * @return
	 */
	@Override
	public Faq addFaq(Faq faq) {

		throw new UnsupportedOperationException(
				"please use instead addFaq(Faq, ServiceContext)");
	}
}