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

package fr.smile.training.faq.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

import fr.smile.training.faq.service.FaqServiceUtil;

import java.rmi.RemoteException;

import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>FaqServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>fr.smile.training.faq.model.FaqSoap</code>. If the method in the
 * service utility returns a
 * <code>fr.smile.training.faq.model.Faq</code>, that is translated to a
 * <code>fr.smile.training.faq.model.FaqSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FaqServiceHttp
 * @generated
 */
@ProviderType
public class FaqServiceSoap {

	public static fr.smile.training.faq.model.FaqSoap addFaq(
			long groupId, String[] titleLanguageIds, String[] titleValues,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> title = LocalizationUtil.getLocalizationMap(
				titleLanguageIds, titleValues);

			fr.smile.training.faq.model.Faq returnValue = FaqServiceUtil.addFaq(
				groupId, title, description, serviceContext);

			return fr.smile.training.faq.model.FaqSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static fr.smile.training.faq.model.FaqSoap[] getFaqsByKeywords(
			long groupId, String keywords, int start, int end, int status,
			com.liferay.portal.kernel.util.OrderByComparator
				<fr.smile.training.faq.model.Faq> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<fr.smile.training.faq.model.Faq> returnValue =
				FaqServiceUtil.getFaqsByKeywords(
					groupId, keywords, start, end, status, orderByComparator);

			return fr.smile.training.faq.model.FaqSoap.toSoapModels(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getFaqsCountByKeywords(
			long groupId, String keywords, int status)
		throws RemoteException {

		try {
			long returnValue = FaqServiceUtil.getFaqsCountByKeywords(
				groupId, keywords, status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static fr.smile.training.faq.model.FaqSoap getFaq(long faqId)
		throws RemoteException {

		try {
			fr.smile.training.faq.model.Faq returnValue = FaqServiceUtil.getFaq(
				faqId);

			return fr.smile.training.faq.model.FaqSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static fr.smile.training.faq.model.FaqSoap updateFaq(
			long faqId, String[] titleMapLanguageIds, String[] titleMapValues,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
				titleMapLanguageIds, titleMapValues);

			fr.smile.training.faq.model.Faq returnValue =
				FaqServiceUtil.updateFaq(
					faqId, titleMap, description, serviceContext);

			return fr.smile.training.faq.model.FaqSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FaqServiceSoap.class);

}