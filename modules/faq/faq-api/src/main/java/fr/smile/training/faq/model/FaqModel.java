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

package fr.smile.training.faq.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Faq service. Represents a row in the &quot;Faq_Faq&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>fr.smile.training.faq.model.impl.FaqModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>fr.smile.training.faq.model.impl.FaqImpl</code>.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see Faq
 * @generated
 */
@ProviderType
public interface FaqModel
	extends BaseModel<Faq>, GroupedModel, LocalizedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a faq model instance should use the {@link Faq} interface instead.
	 */

	/**
	 * Returns the primary key of this faq.
	 *
	 * @return the primary key of this faq
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this faq.
	 *
	 * @param primaryKey the primary key of this faq
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this faq.
	 *
	 * @return the uuid of this faq
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this faq.
	 *
	 * @param uuid the uuid of this faq
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the faq ID of this faq.
	 *
	 * @return the faq ID of this faq
	 */
	public long getFaqId();

	/**
	 * Sets the faq ID of this faq.
	 *
	 * @param faqId the faq ID of this faq
	 */
	public void setFaqId(long faqId);

	/**
	 * Returns the group ID of this faq.
	 *
	 * @return the group ID of this faq
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this faq.
	 *
	 * @param groupId the group ID of this faq
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this faq.
	 *
	 * @return the company ID of this faq
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this faq.
	 *
	 * @param companyId the company ID of this faq
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this faq.
	 *
	 * @return the user ID of this faq
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this faq.
	 *
	 * @param userId the user ID of this faq
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this faq.
	 *
	 * @return the user uuid of this faq
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this faq.
	 *
	 * @param userUuid the user uuid of this faq
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this faq.
	 *
	 * @return the user name of this faq
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this faq.
	 *
	 * @param userName the user name of this faq
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this faq.
	 *
	 * @return the create date of this faq
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this faq.
	 *
	 * @param createDate the create date of this faq
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this faq.
	 *
	 * @return the modified date of this faq
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this faq.
	 *
	 * @param modifiedDate the modified date of this faq
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this faq.
	 *
	 * @return the status of this faq
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this faq.
	 *
	 * @param status the status of this faq
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this faq.
	 *
	 * @return the status by user ID of this faq
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this faq.
	 *
	 * @param statusByUserId the status by user ID of this faq
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this faq.
	 *
	 * @return the status by user uuid of this faq
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this faq.
	 *
	 * @param statusByUserUuid the status by user uuid of this faq
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this faq.
	 *
	 * @return the status by user name of this faq
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this faq.
	 *
	 * @param statusByUserName the status by user name of this faq
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this faq.
	 *
	 * @return the status date of this faq
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this faq.
	 *
	 * @param statusDate the status date of this faq
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this faq.
	 *
	 * @return the title of this faq
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this faq
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this faq
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this faq
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this faq.
	 *
	 * @return the locales and localized titles of this faq
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this faq.
	 *
	 * @param title the title of this faq
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this faq in the language.
	 *
	 * @param title the localized title of this faq
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this faq in the language, and sets the default locale.
	 *
	 * @param title the localized title of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this faq from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this faq
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this faq from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this faq
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the question of this faq.
	 *
	 * @return the question of this faq
	 */
	public String getQuestion();

	/**
	 * Returns the localized question of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized question of this faq
	 */
	@AutoEscape
	public String getQuestion(Locale locale);

	/**
	 * Returns the localized question of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getQuestion(Locale locale, boolean useDefault);

	/**
	 * Returns the localized question of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized question of this faq
	 */
	@AutoEscape
	public String getQuestion(String languageId);

	/**
	 * Returns the localized question of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this faq
	 */
	@AutoEscape
	public String getQuestion(String languageId, boolean useDefault);

	@AutoEscape
	public String getQuestionCurrentLanguageId();

	@AutoEscape
	public String getQuestionCurrentValue();

	/**
	 * Returns a map of the locales and localized questions of this faq.
	 *
	 * @return the locales and localized questions of this faq
	 */
	public Map<Locale, String> getQuestionMap();

	/**
	 * Sets the question of this faq.
	 *
	 * @param question the question of this faq
	 */
	public void setQuestion(String question);

	/**
	 * Sets the localized question of this faq in the language.
	 *
	 * @param question the localized question of this faq
	 * @param locale the locale of the language
	 */
	public void setQuestion(String question, Locale locale);

	/**
	 * Sets the localized question of this faq in the language, and sets the default locale.
	 *
	 * @param question the localized question of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setQuestion(
		String question, Locale locale, Locale defaultLocale);

	public void setQuestionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized questions of this faq from the map of locales and localized questions.
	 *
	 * @param questionMap the locales and localized questions of this faq
	 */
	public void setQuestionMap(Map<Locale, String> questionMap);

	/**
	 * Sets the localized questions of this faq from the map of locales and localized questions, and sets the default locale.
	 *
	 * @param questionMap the locales and localized questions of this faq
	 * @param defaultLocale the default locale
	 */
	public void setQuestionMap(
		Map<Locale, String> questionMap, Locale defaultLocale);

	/**
	 * Returns the answer of this faq.
	 *
	 * @return the answer of this faq
	 */
	public String getAnswer();

	/**
	 * Returns the localized answer of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized answer of this faq
	 */
	@AutoEscape
	public String getAnswer(Locale locale);

	/**
	 * Returns the localized answer of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized answer of this faq. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getAnswer(Locale locale, boolean useDefault);

	/**
	 * Returns the localized answer of this faq in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized answer of this faq
	 */
	@AutoEscape
	public String getAnswer(String languageId);

	/**
	 * Returns the localized answer of this faq in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized answer of this faq
	 */
	@AutoEscape
	public String getAnswer(String languageId, boolean useDefault);

	@AutoEscape
	public String getAnswerCurrentLanguageId();

	@AutoEscape
	public String getAnswerCurrentValue();

	/**
	 * Returns a map of the locales and localized answers of this faq.
	 *
	 * @return the locales and localized answers of this faq
	 */
	public Map<Locale, String> getAnswerMap();

	/**
	 * Sets the answer of this faq.
	 *
	 * @param answer the answer of this faq
	 */
	public void setAnswer(String answer);

	/**
	 * Sets the localized answer of this faq in the language.
	 *
	 * @param answer the localized answer of this faq
	 * @param locale the locale of the language
	 */
	public void setAnswer(String answer, Locale locale);

	/**
	 * Sets the localized answer of this faq in the language, and sets the default locale.
	 *
	 * @param answer the localized answer of this faq
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setAnswer(String answer, Locale locale, Locale defaultLocale);

	public void setAnswerCurrentLanguageId(String languageId);

	/**
	 * Sets the localized answers of this faq from the map of locales and localized answers.
	 *
	 * @param answerMap the locales and localized answers of this faq
	 */
	public void setAnswerMap(Map<Locale, String> answerMap);

	/**
	 * Sets the localized answers of this faq from the map of locales and localized answers, and sets the default locale.
	 *
	 * @param answerMap the locales and localized answers of this faq
	 * @param defaultLocale the default locale
	 */
	public void setAnswerMap(
		Map<Locale, String> answerMap, Locale defaultLocale);

	/**
	 * Returns the description of this faq.
	 *
	 * @return the description of this faq
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this faq.
	 *
	 * @param description the description of this faq
	 */
	public void setDescription(String description);

	/**
	 * Returns <code>true</code> if this faq is approved.
	 *
	 * @return <code>true</code> if this faq is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this faq is denied.
	 *
	 * @return <code>true</code> if this faq is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this faq is a draft.
	 *
	 * @return <code>true</code> if this faq is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this faq is expired.
	 *
	 * @return <code>true</code> if this faq is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this faq is inactive.
	 *
	 * @return <code>true</code> if this faq is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this faq is incomplete.
	 *
	 * @return <code>true</code> if this faq is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this faq is pending.
	 *
	 * @return <code>true</code> if this faq is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this faq is scheduled.
	 *
	 * @return <code>true</code> if this faq is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}