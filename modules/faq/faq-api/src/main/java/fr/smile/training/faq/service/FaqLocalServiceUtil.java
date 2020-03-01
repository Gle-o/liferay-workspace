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

package fr.smile.training.faq.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Faq. This utility wraps
 * <code>fr.smile.training.faq.service.impl.FaqLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Guillaume Lenoir
 * @see FaqLocalService
 * @generated
 */
@ProviderType
public class FaqLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>fr.smile.training.faq.service.impl.FaqLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the faq to the database. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was added
	 */
	public static fr.smile.training.faq.model.Faq addFaq(
		fr.smile.training.faq.model.Faq faq) {

		return getService().addFaq(faq);
	}

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
	public static fr.smile.training.faq.model.Faq addFaq(
			long groupId, java.util.Map<java.util.Locale, String> titleMap,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFaq(
			groupId, titleMap, description, serviceContext);
	}

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	public static fr.smile.training.faq.model.Faq createFaq(long faqId) {
		return getService().createFaq(faqId);
	}

	/**
	 * Deletes the faq from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was removed
	 * @throws PortalException
	 */
	public static fr.smile.training.faq.model.Faq deleteFaq(
			fr.smile.training.faq.model.Faq faq)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFaq(faq);
	}

	/**
	 * Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	public static fr.smile.training.faq.model.Faq deleteFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFaq(faqId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>fr.smile.training.faq.model.impl.FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>fr.smile.training.faq.model.impl.FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static fr.smile.training.faq.model.Faq fetchFaq(long faqId) {
		return getService().fetchFaq(faqId);
	}

	/**
	 * Returns the faq matching the UUID and group.
	 *
	 * @param uuid the faq's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public static fr.smile.training.faq.model.Faq fetchFaqByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchFaqByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the faq with the primary key.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	public static fr.smile.training.faq.model.Faq getFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFaq(faqId);
	}

	/**
	 * Returns the faq matching the UUID and group.
	 *
	 * @param uuid the faq's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faq
	 * @throws PortalException if a matching faq could not be found
	 */
	public static fr.smile.training.faq.model.Faq getFaqByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFaqByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>fr.smile.training.faq.model.impl.FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	public static java.util.List<fr.smile.training.faq.model.Faq> getFaqs(
		int start, int end) {

		return getService().getFaqs(start, end);
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
	public static java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByKeywords(
			long groupId, String keywords, int start, int end, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.smile.training.faq.model.Faq> orderByComparator) {

		return getService().getFaqsByKeywords(
			groupId, keywords, start, end, status, orderByComparator);
	}

	public static java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByStatus(int status) {

		return getService().getFaqsByStatus(status);
	}

	/**
	 * Returns all the faqs matching the UUID and company.
	 *
	 * @param uuid the UUID of the faqs
	 * @param companyId the primary key of the company
	 * @return the matching faqs, or an empty list if no matches were found
	 */
	public static java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getFaqsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of faqs matching the UUID and company.
	 *
	 * @param uuid the UUID of the faqs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching faqs, or an empty list if no matches were found
	 */
	public static java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.smile.training.faq.model.Faq> orderByComparator) {

		return getService().getFaqsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	public static int getFaqsCount() {
		return getService().getFaqsCount();
	}

	public static int getFaqsCountByGroupId(long groupId) {
		return getService().getFaqsCountByGroupId(groupId);
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
	public static long getFaqsCountByKeywords(
		long groupId, String keywords, int status) {

		return getService().getFaqsCountByKeywords(groupId, keywords, status);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was updated
	 */
	public static fr.smile.training.faq.model.Faq updateFaq(
		fr.smile.training.faq.model.Faq faq) {

		return getService().updateFaq(faq);
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
	public static fr.smile.training.faq.model.Faq updateFaq(
			long faqId, java.util.Map<java.util.Locale, String> titleMap,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFaq(
			faqId, titleMap, description, serviceContext);
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
	public static fr.smile.training.faq.model.Faq updateStatus(
			long userId, long faqId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return getService().updateStatus(userId, faqId, status, serviceContext);
	}

	public static FaqLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FaqLocalService, FaqLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FaqLocalService.class);

		ServiceTracker<FaqLocalService, FaqLocalService> serviceTracker =
			new ServiceTracker<FaqLocalService, FaqLocalService>(
				bundle.getBundleContext(), FaqLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}