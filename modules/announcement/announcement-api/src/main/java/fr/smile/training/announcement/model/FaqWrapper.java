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

package fr.smile.training.announcement.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Faq}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Faq
 * @generated
 */
@ProviderType
public class FaqWrapper
	extends BaseModelWrapper<Faq> implements Faq, ModelWrapper<Faq> {

	public FaqWrapper(Faq faq) {
		super(faq);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("faqId", getFaqId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("question", getQuestion());
		attributes.put("answer", getAnswer());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long faqId = (Long)attributes.get("faqId");

		if (faqId != null) {
			setFaqId(faqId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the answer of this faq.
	 *
	 * @return the answer of this faq
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the localized answer of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized answer of this faq
	 */
	@Override
	public String getAnswer(java.util.Locale locale) {
		return model.getAnswer(locale);
	}

	/**
	 * Returns the localized answer of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized answer of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getAnswer(java.util.Locale locale, boolean useDefault) {
		return model.getAnswer(locale, useDefault);
	}

	/**
	 * Returns the localized answer of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized answer of this faq
	 */
	@Override
	public String getAnswer(String languageId) {
		return model.getAnswer(languageId);
	}

	/**
	 * Returns the localized answer of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized answer of this faq
	 */
	@Override
	public String getAnswer(String languageId, boolean useDefault) {
		return model.getAnswer(languageId, useDefault);
	}

	@Override
	public String getAnswerCurrentLanguageId() {
		return model.getAnswerCurrentLanguageId();
	}

	@Override
	public String getAnswerCurrentValue() {
		return model.getAnswerCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized answers of this faq.
	 *
	 * @return the locales and localized answers of this faq
	 */
	@Override
	public Map<java.util.Locale, String> getAnswerMap() {
		return model.getAnswerMap();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this faq.
	 *
	 * @return the company ID of this faq
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this faq.
	 *
	 * @return the create date of this faq
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this faq.
	 *
	 * @return the description of this faq
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the faq ID of this faq.
	 *
	 * @return the faq ID of this faq
	 */
	@Override
	public long getFaqId() {
		return model.getFaqId();
	}

	/**
	 * Returns the group ID of this faq.
	 *
	 * @return the group ID of this faq
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this faq.
	 *
	 * @return the modified date of this faq
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this faq.
	 *
	 * @return the primary key of this faq
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question of this faq.
	 *
	 * @return the question of this faq
	 */
	@Override
	public String getQuestion() {
		return model.getQuestion();
	}

	/**
	 * Returns the localized question of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized question of this faq
	 */
	@Override
	public String getQuestion(java.util.Locale locale) {
		return model.getQuestion(locale);
	}

	/**
	 * Returns the localized question of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getQuestion(java.util.Locale locale, boolean useDefault) {
		return model.getQuestion(locale, useDefault);
	}

	/**
	 * Returns the localized question of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized question of this faq
	 */
	@Override
	public String getQuestion(String languageId) {
		return model.getQuestion(languageId);
	}

	/**
	 * Returns the localized question of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this faq
	 */
	@Override
	public String getQuestion(String languageId, boolean useDefault) {
		return model.getQuestion(languageId, useDefault);
	}

	@Override
	public String getQuestionCurrentLanguageId() {
		return model.getQuestionCurrentLanguageId();
	}

	@Override
	public String getQuestionCurrentValue() {
		return model.getQuestionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized questions of this faq.
	 *
	 * @return the locales and localized questions of this faq
	 */
	@Override
	public Map<java.util.Locale, String> getQuestionMap() {
		return model.getQuestionMap();
	}

	/**
	 * Returns the status of this faq.
	 *
	 * @return the status of this faq
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this faq.
	 *
	 * @return the status by user ID of this faq
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this faq.
	 *
	 * @return the status by user name of this faq
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this faq.
	 *
	 * @return the status by user uuid of this faq
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this faq.
	 *
	 * @return the status date of this faq
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this faq.
	 *
	 * @return the title of this faq
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this faq
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this faq
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this faq
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this faq.
	 *
	 * @return the locales and localized titles of this faq
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the user ID of this faq.
	 *
	 * @return the user ID of this faq
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this faq.
	 *
	 * @return the user name of this faq
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this faq.
	 *
	 * @return the user uuid of this faq
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this faq.
	 *
	 * @return the uuid of this faq
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this faq is approved.
	 *
	 * @return <code>true</code> if this faq is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this faq is denied.
	 *
	 * @return <code>true</code> if this faq is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this faq is a draft.
	 *
	 * @return <code>true</code> if this faq is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this faq is expired.
	 *
	 * @return <code>true</code> if this faq is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this faq is inactive.
	 *
	 * @return <code>true</code> if this faq is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this faq is incomplete.
	 *
	 * @return <code>true</code> if this faq is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this faq is pending.
	 *
	 * @return <code>true</code> if this faq is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this faq is scheduled.
	 *
	 * @return <code>true</code> if this faq is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the answer of this faq.
	 *
	 * @param answer the answer of this faq
	 */
	@Override
	public void setAnswer(String answer) {
		model.setAnswer(answer);
	}

	/**
	 * Sets the localized answer of this faq in the language.
	 *
	 * @param answer the localized answer of this faq
	 * @param locale the locale of the language
	 */
	@Override
	public void setAnswer(String answer, java.util.Locale locale) {
		model.setAnswer(answer, locale);
	}

	/**
	 * Sets the localized answer of this faq in the language, and sets the default locale.
	 *
	 * @param answer the localized answer of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAnswer(
		String answer, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setAnswer(answer, locale, defaultLocale);
	}

	@Override
	public void setAnswerCurrentLanguageId(String languageId) {
		model.setAnswerCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized answers of this faq from the map of locales and localized answers.
	 *
	 * @param answerMap the locales and localized answers of this faq
	 */
	@Override
	public void setAnswerMap(Map<java.util.Locale, String> answerMap) {
		model.setAnswerMap(answerMap);
	}

	/**
	 * Sets the localized answers of this faq from the map of locales and localized answers, and sets the default locale.
	 *
	 * @param answerMap the locales and localized answers of this faq
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setAnswerMap(
		Map<java.util.Locale, String> answerMap,
		java.util.Locale defaultLocale) {

		model.setAnswerMap(answerMap, defaultLocale);
	}

	/**
	 * Sets the company ID of this faq.
	 *
	 * @param companyId the company ID of this faq
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this faq.
	 *
	 * @param createDate the create date of this faq
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this faq.
	 *
	 * @param description the description of this faq
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the faq ID of this faq.
	 *
	 * @param faqId the faq ID of this faq
	 */
	@Override
	public void setFaqId(long faqId) {
		model.setFaqId(faqId);
	}

	/**
	 * Sets the group ID of this faq.
	 *
	 * @param groupId the group ID of this faq
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this faq.
	 *
	 * @param modifiedDate the modified date of this faq
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this faq.
	 *
	 * @param primaryKey the primary key of this faq
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question of this faq.
	 *
	 * @param question the question of this faq
	 */
	@Override
	public void setQuestion(String question) {
		model.setQuestion(question);
	}

	/**
	 * Sets the localized question of this faq in the language.
	 *
	 * @param question the localized question of this faq
	 * @param locale the locale of the language
	 */
	@Override
	public void setQuestion(String question, java.util.Locale locale) {
		model.setQuestion(question, locale);
	}

	/**
	 * Sets the localized question of this faq in the language, and sets the default locale.
	 *
	 * @param question the localized question of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setQuestion(
		String question, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setQuestion(question, locale, defaultLocale);
	}

	@Override
	public void setQuestionCurrentLanguageId(String languageId) {
		model.setQuestionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized questions of this faq from the map of locales and localized questions.
	 *
	 * @param questionMap the locales and localized questions of this faq
	 */
	@Override
	public void setQuestionMap(Map<java.util.Locale, String> questionMap) {
		model.setQuestionMap(questionMap);
	}

	/**
	 * Sets the localized questions of this faq from the map of locales and localized questions, and sets the default locale.
	 *
	 * @param questionMap the locales and localized questions of this faq
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setQuestionMap(
		Map<java.util.Locale, String> questionMap,
		java.util.Locale defaultLocale) {

		model.setQuestionMap(questionMap, defaultLocale);
	}

	/**
	 * Sets the status of this faq.
	 *
	 * @param status the status of this faq
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this faq.
	 *
	 * @param statusByUserId the status by user ID of this faq
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this faq.
	 *
	 * @param statusByUserName the status by user name of this faq
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this faq.
	 *
	 * @param statusByUserUuid the status by user uuid of this faq
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this faq.
	 *
	 * @param statusDate the status date of this faq
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this faq.
	 *
	 * @param title the title of this faq
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this faq in the language.
	 *
	 * @param title the localized title of this faq
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this faq in the language, and sets the default locale.
	 *
	 * @param title the localized title of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this faq from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this faq
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this faq from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this faq
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this faq.
	 *
	 * @param userId the user ID of this faq
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this faq.
	 *
	 * @param userName the user name of this faq
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this faq.
	 *
	 * @param userUuid the user uuid of this faq
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this faq.
	 *
	 * @param uuid the uuid of this faq
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected FaqWrapper wrap(Faq faq) {
		return new FaqWrapper(faq);
	}

}