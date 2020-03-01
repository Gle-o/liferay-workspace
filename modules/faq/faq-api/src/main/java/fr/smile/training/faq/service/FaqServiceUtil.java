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
 * Provides the remote service utility for Faq. This utility wraps
 * <code>fr.smile.training.faq.service.impl.FaqServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see FaqService
 * @generated
 */
@ProviderType
public class FaqServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>fr.smile.training.faq.service.impl.FaqServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static fr.smile.training.faq.model.Faq addFaq(
			long groupId, java.util.Map<java.util.Locale, String> title,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFaq(groupId, title, description, serviceContext);
	}

	public static fr.smile.training.faq.model.Faq deleteFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFaq(faqId);
	}

	public static fr.smile.training.faq.model.Faq getFaq(long faqId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFaq(faqId);
	}

	public static java.util.List<fr.smile.training.faq.model.Faq>
		getFaqsByKeywords(
			long groupId, String keywords, int start, int end, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.smile.training.faq.model.Faq> orderByComparator) {

		return getService().getFaqsByKeywords(
			groupId, keywords, start, end, status, orderByComparator);
	}

	public static long getFaqsCountByKeywords(
		long groupId, String keywords, int status) {

		return getService().getFaqsCountByKeywords(groupId, keywords, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static fr.smile.training.faq.model.Faq updateFaq(
			long faqId, java.util.Map<java.util.Locale, String> titleMap,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFaq(
			faqId, titleMap, description, serviceContext);
	}

	public static FaqService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FaqService, FaqService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FaqService.class);

		ServiceTracker<FaqService, FaqService> serviceTracker =
			new ServiceTracker<FaqService, FaqService>(
				bundle.getBundleContext(), FaqService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}