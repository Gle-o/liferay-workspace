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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link FaqLocalService}.
 *
 * @author Guillaume Lenoir
 * @see FaqLocalService
 * @generated
 */
@ProviderType
public class FaqLocalServiceWrapper
	implements FaqLocalService, ServiceWrapper<FaqLocalService> {

	public FaqLocalServiceWrapper(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	/**
	 * Adds the faq to the database. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was added
	 */
	@Override
	public fr.smile.training.faq.model.Faq addFaq(
		fr.smile.training.faq.model.Faq faq) {

		return _faqLocalService.addFaq(faq);
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
	@Override
	public fr.smile.training.faq.model.Faq addFaq(
			long groupId, java.util.Map<java.util.Locale, String> titleMap,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.addFaq(
			groupId, titleMap, description, serviceContext);
	}

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	@Override
	public fr.smile.training.faq.model.Faq createFaq(long faqId) {
		return _faqLocalService.createFaq(faqId);
	}

	/**
	 * Deletes the faq from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was removed
	 * @throws PortalException
	 */
	@Override
	public fr.smile.training.faq.model.Faq deleteFaq(
			fr.smile.training.faq.model.Faq faq)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.deleteFaq(faq);
	}

	/**
	 * Deletes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	@Override
	public fr.smile.training.faq.model.Faq deleteFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.deleteFaq(faqId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _faqLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _faqLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _faqLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _faqLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _faqLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _faqLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public fr.smile.training.faq.model.Faq fetchFaq(long faqId) {
		return _faqLocalService.fetchFaq(faqId);
	}

	/**
	 * Returns the faq matching the UUID and group.
	 *
	 * @param uuid the faq's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Override
	public fr.smile.training.faq.model.Faq fetchFaqByUuidAndGroupId(
		String uuid, long groupId) {

		return _faqLocalService.fetchFaqByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _faqLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _faqLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the faq with the primary key.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws PortalException if a faq with the primary key could not be found
	 */
	@Override
	public fr.smile.training.faq.model.Faq getFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.getFaq(faqId);
	}

	/**
	 * Returns the faq matching the UUID and group.
	 *
	 * @param uuid the faq's UUID
	 * @param groupId the primary key of the group
	 * @return the matching faq
	 * @throws PortalException if a matching faq could not be found
	 */
	@Override
	public fr.smile.training.faq.model.Faq getFaqByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.getFaqByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<fr.smile.training.faq.model.Faq> getFaqs(
		int start, int end) {

		return _faqLocalService.getFaqs(start, end);
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
	@Override
	public java.util.List<fr.smile.training.faq.model.Faq> getFaqsByKeywords(
		long groupId, String keywords, int start, int end, int status,
		com.liferay.portal.kernel.util.OrderByComparator
			<fr.smile.training.faq.model.Faq> orderByComparator) {

		return _faqLocalService.getFaqsByKeywords(
			groupId, keywords, start, end, status, orderByComparator);
	}

	@Override
	public java.util.List<fr.smile.training.faq.model.Faq> getFaqsByStatus(
		int status) {

		return _faqLocalService.getFaqsByStatus(status);
	}

	/**
	 * Returns all the faqs matching the UUID and company.
	 *
	 * @param uuid the UUID of the faqs
	 * @param companyId the primary key of the company
	 * @return the matching faqs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByUuidAndCompanyId(String uuid, long companyId) {

		return _faqLocalService.getFaqsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.smile.training.faq.model.Faq> orderByComparator) {

		return _faqLocalService.getFaqsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	@Override
	public int getFaqsCount() {
		return _faqLocalService.getFaqsCount();
	}

	@Override
	public int getFaqsCountByGroupId(long groupId) {
		return _faqLocalService.getFaqsCountByGroupId(groupId);
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
	@Override
	public long getFaqsCountByKeywords(
		long groupId, String keywords, int status) {

		return _faqLocalService.getFaqsCountByKeywords(
			groupId, keywords, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _faqLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _faqLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the faq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param faq the faq
	 * @return the faq that was updated
	 */
	@Override
	public fr.smile.training.faq.model.Faq updateFaq(
		fr.smile.training.faq.model.Faq faq) {

		return _faqLocalService.updateFaq(faq);
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
	@Override
	public fr.smile.training.faq.model.Faq updateFaq(
			long faqId, java.util.Map<java.util.Locale, String> titleMap,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqLocalService.updateFaq(
			faqId, titleMap, description, serviceContext);
	}

	@Override
	public FaqLocalService getWrappedService() {
		return _faqLocalService;
	}

	@Override
	public void setWrappedService(FaqLocalService faqLocalService) {
		_faqLocalService = faqLocalService;
	}

	private FaqLocalService _faqLocalService;

}