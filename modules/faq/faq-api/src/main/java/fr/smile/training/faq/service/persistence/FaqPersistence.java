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

package fr.smile.training.faq.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import fr.smile.training.faq.exception.NoSuchFaqException;
import fr.smile.training.faq.model.Faq;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the faq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FaqUtil
 * @generated
 */
@ProviderType
public interface FaqPersistence extends BasePersistence<Faq> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FaqUtil} to access the faq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the faqs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faqs
	 */
	public java.util.List<Faq> findByUuid(String uuid);

	/**
	 * Returns a range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<Faq> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Deprecated
	public java.util.List<Faq> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<Faq> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the first faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByUuid_First(
			String uuid, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the first faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByUuid_First(
		String uuid, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the last faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByUuid_Last(
			String uuid, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the last faq in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByUuid_Last(
		String uuid, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where uuid = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] findByUuid_PrevAndNext(
			long faqId, String uuid, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Removes all the faqs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of faqs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faqs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the faq where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFaqException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByUUID_G(String uuid, long groupId)
		throws NoSuchFaqException;

	/**
	 * Returns the faq where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faq, or <code>null</code> if a matching faq could not be found
	 */
	@Deprecated
	public Faq fetchByUUID_G(String uuid, long groupId, boolean useFinderCache);

	/**
	 * Returns the faq where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByUUID_G(String uuid, long groupId);

	/**
	 * Removes the faq where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faq that was removed
	 */
	public Faq removeByUUID_G(String uuid, long groupId)
		throws NoSuchFaqException;

	/**
	 * Returns the number of faqs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faqs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the faqs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faqs
	 */
	public java.util.List<Faq> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the faqs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<Faq> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Deprecated
	public java.util.List<Faq> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<Faq> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the first faq in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the first faq in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByUuid_C_First(
		String uuid, long companyId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the last faq in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the last faq in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByUuid_C_Last(
		String uuid, long companyId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] findByUuid_C_PrevAndNext(
			long faqId, String uuid, long companyId,
			OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Removes all the faqs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of faqs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faqs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the faqs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching faqs
	 */
	public java.util.List<Faq> findByGroupId(long groupId);

	/**
	 * Returns a range of all the faqs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<Faq> findByGroupId(long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupId(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Deprecated
	public java.util.List<Faq> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<Faq> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the first faq in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByGroupId_First(
			long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the first faq in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByGroupId_First(
		long groupId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the last faq in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByGroupId_Last(
			long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the last faq in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByGroupId_Last(
		long groupId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where groupId = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] findByGroupId_PrevAndNext(
			long faqId, long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns all the faqs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the faqs that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the faqs that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set of faqs that the user has permission to view where groupId = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] filterFindByGroupId_PrevAndNext(
			long faqId, long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Removes all the faqs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of faqs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching faqs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of faqs that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching faqs that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the faqs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching faqs
	 */
	public java.util.List<Faq> findByStatus(int status);

	/**
	 * Returns a range of all the faqs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<Faq> findByStatus(int status, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByStatus(int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Deprecated
	public java.util.List<Faq> findByStatus(
		int status, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<Faq> findByStatus(
		int status, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the first faq in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByStatus_First(
			int status, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the first faq in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByStatus_First(
		int status, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the last faq in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByStatus_Last(
			int status, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the last faq in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByStatus_Last(
		int status, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where status = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] findByStatus_PrevAndNext(
			long faqId, int status, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Removes all the faqs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of faqs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching faqs
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the faqs where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching faqs
	 */
	public java.util.List<Faq> findByG_S(int status, long groupId);

	/**
	 * Returns a range of all the faqs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs
	 */
	public java.util.List<Faq> findByG_S(
		int status, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the faqs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByG_S(int,long, int, int, OrderByComparator)}
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faqs
	 */
	@Deprecated
	public java.util.List<Faq> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs
	 */
	public java.util.List<Faq> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the first faq in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByG_S_First(
			int status, long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the first faq in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByG_S_First(
		int status, long groupId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the last faq in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq
	 * @throws NoSuchFaqException if a matching faq could not be found
	 */
	public Faq findByG_S_Last(
			int status, long groupId, OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns the last faq in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faq, or <code>null</code> if a matching faq could not be found
	 */
	public Faq fetchByG_S_Last(
		int status, long groupId, OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] findByG_S_PrevAndNext(
			long faqId, int status, long groupId,
			OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Returns all the faqs that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByG_S(int status, long groupId);

	/**
	 * Returns a range of all the faqs that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByG_S(
		int status, long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the faqs that the user has permissions to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faqs that the user has permission to view
	 */
	public java.util.List<Faq> filterFindByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<Faq> orderByComparator);

	/**
	 * Returns the faqs before and after the current faq in the ordered set of faqs that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param faqId the primary key of the current faq
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq[] filterFindByG_S_PrevAndNext(
			long faqId, int status, long groupId,
			OrderByComparator<Faq> orderByComparator)
		throws NoSuchFaqException;

	/**
	 * Removes all the faqs where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public void removeByG_S(int status, long groupId);

	/**
	 * Returns the number of faqs where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching faqs
	 */
	public int countByG_S(int status, long groupId);

	/**
	 * Returns the number of faqs that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching faqs that the user has permission to view
	 */
	public int filterCountByG_S(int status, long groupId);

	/**
	 * Caches the faq in the entity cache if it is enabled.
	 *
	 * @param faq the faq
	 */
	public void cacheResult(Faq faq);

	/**
	 * Caches the faqs in the entity cache if it is enabled.
	 *
	 * @param faqs the faqs
	 */
	public void cacheResult(java.util.List<Faq> faqs);

	/**
	 * Creates a new faq with the primary key. Does not add the faq to the database.
	 *
	 * @param faqId the primary key for the new faq
	 * @return the new faq
	 */
	public Faq create(long faqId);

	/**
	 * Removes the faq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq that was removed
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq remove(long faqId) throws NoSuchFaqException;

	public Faq updateImpl(Faq faq);

	/**
	 * Returns the faq with the primary key or throws a <code>NoSuchFaqException</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq
	 * @throws NoSuchFaqException if a faq with the primary key could not be found
	 */
	public Faq findByPrimaryKey(long faqId) throws NoSuchFaqException;

	/**
	 * Returns the faq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param faqId the primary key of the faq
	 * @return the faq, or <code>null</code> if a faq with the primary key could not be found
	 */
	public Faq fetchByPrimaryKey(long faqId);

	/**
	 * Returns all the faqs.
	 *
	 * @return the faqs
	 */
	public java.util.List<Faq> findAll();

	/**
	 * Returns a range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @return the range of faqs
	 */
	public java.util.List<Faq> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faqs
	 */
	@Deprecated
	public java.util.List<Faq> findAll(
		int start, int end, OrderByComparator<Faq> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the faqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FaqModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of faqs
	 * @param end the upper bound of the range of faqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faqs
	 */
	public java.util.List<Faq> findAll(
		int start, int end, OrderByComparator<Faq> orderByComparator);

	/**
	 * Removes all the faqs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of faqs.
	 *
	 * @return the number of faqs
	 */
	public int countAll();

}