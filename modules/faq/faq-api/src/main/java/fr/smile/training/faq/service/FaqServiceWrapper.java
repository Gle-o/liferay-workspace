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
 * Provides a wrapper for {@link FaqService}.
 *
 * @author Guillaume Lenoir
 * @see FaqService
 * @generated
 */
@ProviderType
public class FaqServiceWrapper
	implements FaqService, ServiceWrapper<FaqService> {

	public FaqServiceWrapper(FaqService faqService) {
		_faqService = faqService;
	}

	@Override
	public fr.smile.training.faq.model.Faq addFaq(
			long groupId, java.util.Map<java.util.Locale, String> title,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _faqService.addFaq(groupId, title, description, serviceContext);
	}

	@Override
	public java.util.List<fr.smile.training.faq.model.Faq> getFaqsByKeywords(
		long groupId, String keywords, int start, int end, int status,
		com.liferay.portal.kernel.util.OrderByComparator
			<fr.smile.training.faq.model.Faq> orderByComparator) {

		return _faqService.getFaqsByKeywords(
			groupId, keywords, start, end, status, orderByComparator);
	}

	@Override
	public long getFaqsCountByKeywords(
		long groupId, String keywords, int status) {

		return _faqService.getFaqsCountByKeywords(groupId, keywords, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _faqService.getOSGiServiceIdentifier();
	}

	@Override
	public FaqService getWrappedService() {
		return _faqService;
	}

	@Override
	public void setWrappedService(FaqService faqService) {
		_faqService = faqService;
	}

	private FaqService _faqService;

}