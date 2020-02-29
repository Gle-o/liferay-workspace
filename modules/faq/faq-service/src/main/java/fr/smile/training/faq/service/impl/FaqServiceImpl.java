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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.base.FaqServiceBaseImpl;
import fr.smile.training.faq.service.permission.FaqPermissionChecker;
import fr.smile.training.faq.service.permission.impl.FaqPermissionCheckerImpl;

/**
 * The implementation of the faq remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>fr.smile.training.faq.service.FaqService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FaqServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=faq", "json.web.service.context.path=Faq"
	},
	service = AopService.class
)
public class FaqServiceImpl extends FaqServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>fr.smile.training.faq.service.FaqServiceUtil</code> to access the faq remote service.
	 */
	
	public Faq addFaq(long groupId, Map<Locale, String> title, String description, ServiceContext serviceContext) throws PortalException {

		// Check permissions
		
		_faqPermissionChecker.checkTopLevel(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				FaqPermissionCheckerImpl.ADD);
		
		return faqLocalService.addFaq(groupId, title, description, serviceContext);
	}
	
	public List<Faq> getFaqsByKeywords(long groupId, String keywords, int start, int end, int status, OrderByComparator<Faq> orderByComparator) {
		return faqLocalService.getFaqsByKeywords(groupId, keywords, start, end, status, orderByComparator);
	}
	
	public long getFaqsCountByKeywords(long groupId, String keywords, int status) {
		return faqLocalService.getFaqsCountByKeywords(groupId, keywords, status);
	}
	
	@Reference(
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=fr.smile.training.faq.model.Faq)"
		)
		private volatile FaqPermissionChecker _faqPermissionChecker;
}