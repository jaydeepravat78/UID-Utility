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

package absli.uid.helper.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Absli}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Absli
 * @generated
 */
public class AbsliWrapper
	extends BaseModelWrapper<Absli> implements Absli, ModelWrapper<Absli> {

	public AbsliWrapper(Absli absli) {
		super(absli);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uId", getUId());
		attributes.put("product", getProduct());
		attributes.put("agentCode", getAgentCode());
		attributes.put("sourceName", getSourceName());
		attributes.put("discount", isDiscount());
		attributes.put("createdBy", getCreatedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		String uId = (String)attributes.get("uId");

		if (uId != null) {
			setUId(uId);
		}

		String product = (String)attributes.get("product");

		if (product != null) {
			setProduct(product);
		}

		String agentCode = (String)attributes.get("agentCode");

		if (agentCode != null) {
			setAgentCode(agentCode);
		}

		String sourceName = (String)attributes.get("sourceName");

		if (sourceName != null) {
			setSourceName(sourceName);
		}

		Boolean discount = (Boolean)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}
	}

	@Override
	public Absli cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agent code of this absli.
	 *
	 * @return the agent code of this absli
	 */
	@Override
	public String getAgentCode() {
		return model.getAgentCode();
	}

	/**
	 * Returns the company ID of this absli.
	 *
	 * @return the company ID of this absli
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this absli.
	 *
	 * @return the create date of this absli
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by of this absli.
	 *
	 * @return the created by of this absli
	 */
	@Override
	public String getCreatedBy() {
		return model.getCreatedBy();
	}

	/**
	 * Returns the discount of this absli.
	 *
	 * @return the discount of this absli
	 */
	@Override
	public boolean getDiscount() {
		return model.getDiscount();
	}

	/**
	 * Returns the group ID of this absli.
	 *
	 * @return the group ID of this absli
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this absli.
	 *
	 * @return the ID of this absli
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this absli.
	 *
	 * @return the modified date of this absli
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this absli.
	 *
	 * @return the primary key of this absli
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product of this absli.
	 *
	 * @return the product of this absli
	 */
	@Override
	public String getProduct() {
		return model.getProduct();
	}

	/**
	 * Returns the source name of this absli.
	 *
	 * @return the source name of this absli
	 */
	@Override
	public String getSourceName() {
		return model.getSourceName();
	}

	/**
	 * Returns the u ID of this absli.
	 *
	 * @return the u ID of this absli
	 */
	@Override
	public String getUId() {
		return model.getUId();
	}

	/**
	 * Returns the user ID of this absli.
	 *
	 * @return the user ID of this absli
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this absli.
	 *
	 * @return the user name of this absli
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this absli.
	 *
	 * @return the user uuid of this absli
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this absli.
	 *
	 * @return the uuid of this absli
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this absli is discount.
	 *
	 * @return <code>true</code> if this absli is discount; <code>false</code> otherwise
	 */
	@Override
	public boolean isDiscount() {
		return model.isDiscount();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the agent code of this absli.
	 *
	 * @param agentCode the agent code of this absli
	 */
	@Override
	public void setAgentCode(String agentCode) {
		model.setAgentCode(agentCode);
	}

	/**
	 * Sets the company ID of this absli.
	 *
	 * @param companyId the company ID of this absli
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this absli.
	 *
	 * @param createDate the create date of this absli
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by of this absli.
	 *
	 * @param createdBy the created by of this absli
	 */
	@Override
	public void setCreatedBy(String createdBy) {
		model.setCreatedBy(createdBy);
	}

	/**
	 * Sets whether this absli is discount.
	 *
	 * @param discount the discount of this absli
	 */
	@Override
	public void setDiscount(boolean discount) {
		model.setDiscount(discount);
	}

	/**
	 * Sets the group ID of this absli.
	 *
	 * @param groupId the group ID of this absli
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this absli.
	 *
	 * @param id the ID of this absli
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this absli.
	 *
	 * @param modifiedDate the modified date of this absli
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this absli.
	 *
	 * @param primaryKey the primary key of this absli
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product of this absli.
	 *
	 * @param product the product of this absli
	 */
	@Override
	public void setProduct(String product) {
		model.setProduct(product);
	}

	/**
	 * Sets the source name of this absli.
	 *
	 * @param sourceName the source name of this absli
	 */
	@Override
	public void setSourceName(String sourceName) {
		model.setSourceName(sourceName);
	}

	/**
	 * Sets the u ID of this absli.
	 *
	 * @param uId the u ID of this absli
	 */
	@Override
	public void setUId(String uId) {
		model.setUId(uId);
	}

	/**
	 * Sets the user ID of this absli.
	 *
	 * @param userId the user ID of this absli
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this absli.
	 *
	 * @param userName the user name of this absli
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this absli.
	 *
	 * @param userUuid the user uuid of this absli
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this absli.
	 *
	 * @param uuid the uuid of this absli
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
	protected AbsliWrapper wrap(Absli absli) {
		return new AbsliWrapper(absli);
	}

}