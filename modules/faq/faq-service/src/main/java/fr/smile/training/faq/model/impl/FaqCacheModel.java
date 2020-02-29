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

package fr.smile.training.faq.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fr.smile.training.faq.model.Faq;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Faq in entity cache.
 *
 * @author Guillaume Lenoir
 * @generated
 */
@ProviderType
public class FaqCacheModel implements CacheModel<Faq>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FaqCacheModel)) {
			return false;
		}

		FaqCacheModel faqCacheModel = (FaqCacheModel)obj;

		if (faqId == faqCacheModel.faqId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, faqId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", faqId=");
		sb.append(faqId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", question=");
		sb.append(question);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Faq toEntityModel() {
		FaqImpl faqImpl = new FaqImpl();

		if (uuid == null) {
			faqImpl.setUuid("");
		}
		else {
			faqImpl.setUuid(uuid);
		}

		faqImpl.setFaqId(faqId);
		faqImpl.setGroupId(groupId);
		faqImpl.setCompanyId(companyId);
		faqImpl.setUserId(userId);

		if (userName == null) {
			faqImpl.setUserName("");
		}
		else {
			faqImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			faqImpl.setCreateDate(null);
		}
		else {
			faqImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			faqImpl.setModifiedDate(null);
		}
		else {
			faqImpl.setModifiedDate(new Date(modifiedDate));
		}

		faqImpl.setStatus(status);
		faqImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			faqImpl.setStatusByUserName("");
		}
		else {
			faqImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			faqImpl.setStatusDate(null);
		}
		else {
			faqImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			faqImpl.setTitle("");
		}
		else {
			faqImpl.setTitle(title);
		}

		if (question == null) {
			faqImpl.setQuestion("");
		}
		else {
			faqImpl.setQuestion(question);
		}

		if (answer == null) {
			faqImpl.setAnswer("");
		}
		else {
			faqImpl.setAnswer(answer);
		}

		if (description == null) {
			faqImpl.setDescription("");
		}
		else {
			faqImpl.setDescription(description);
		}

		faqImpl.resetOriginalValues();

		return faqImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		faqId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		question = objectInput.readUTF();
		answer = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(faqId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (question == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(answer);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long faqId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String question;
	public String answer;
	public String description;

}