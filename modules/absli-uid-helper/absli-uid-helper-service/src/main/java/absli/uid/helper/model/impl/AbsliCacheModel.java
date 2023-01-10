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

package absli.uid.helper.model.impl;

import absli.uid.helper.model.Absli;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Absli in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AbsliCacheModel implements CacheModel<Absli>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AbsliCacheModel)) {
			return false;
		}

		AbsliCacheModel absliCacheModel = (AbsliCacheModel)object;

		if (id == absliCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
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
		sb.append(", uId=");
		sb.append(uId);
		sb.append(", product=");
		sb.append(product);
		sb.append(", agentCode=");
		sb.append(agentCode);
		sb.append(", sourceName=");
		sb.append(sourceName);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Absli toEntityModel() {
		AbsliImpl absliImpl = new AbsliImpl();

		if (uuid == null) {
			absliImpl.setUuid("");
		}
		else {
			absliImpl.setUuid(uuid);
		}

		absliImpl.setId(id);
		absliImpl.setGroupId(groupId);
		absliImpl.setCompanyId(companyId);
		absliImpl.setUserId(userId);

		if (userName == null) {
			absliImpl.setUserName("");
		}
		else {
			absliImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			absliImpl.setCreateDate(null);
		}
		else {
			absliImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			absliImpl.setModifiedDate(null);
		}
		else {
			absliImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uId == null) {
			absliImpl.setUId("");
		}
		else {
			absliImpl.setUId(uId);
		}

		if (product == null) {
			absliImpl.setProduct("");
		}
		else {
			absliImpl.setProduct(product);
		}

		if (agentCode == null) {
			absliImpl.setAgentCode("");
		}
		else {
			absliImpl.setAgentCode(agentCode);
		}

		if (sourceName == null) {
			absliImpl.setSourceName("");
		}
		else {
			absliImpl.setSourceName(sourceName);
		}

		absliImpl.setDiscount(discount);

		if (createdBy == null) {
			absliImpl.setCreatedBy("");
		}
		else {
			absliImpl.setCreatedBy(createdBy);
		}

		absliImpl.resetOriginalValues();

		return absliImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uId = objectInput.readUTF();
		product = objectInput.readUTF();
		agentCode = objectInput.readUTF();
		sourceName = objectInput.readUTF();

		discount = objectInput.readBoolean();
		createdBy = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

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

		if (uId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uId);
		}

		if (product == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(product);
		}

		if (agentCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(agentCode);
		}

		if (sourceName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sourceName);
		}

		objectOutput.writeBoolean(discount);

		if (createdBy == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(createdBy);
		}
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String uId;
	public String product;
	public String agentCode;
	public String sourceName;
	public boolean discount;
	public String createdBy;

}