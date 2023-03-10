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
import absli.uid.helper.model.AbsliModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Absli service. Represents a row in the &quot;AB_Absli&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AbsliModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AbsliImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AbsliImpl
 * @generated
 */
@JSON(strict = true)
public class AbsliModelImpl extends BaseModelImpl<Absli> implements AbsliModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a absli model instance should use the <code>Absli</code> interface instead.
	 */
	public static final String TABLE_NAME = "AB_Absli";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"uId", Types.VARCHAR}, {"product", Types.VARCHAR},
		{"agentCode", Types.VARCHAR}, {"sourceName", Types.VARCHAR},
		{"discount", Types.BOOLEAN}, {"createdBy", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("uId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("product", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("agentCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sourceName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("discount", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("createdBy", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AB_Absli (uuid_ VARCHAR(75) null,id_ LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,uId VARCHAR(75) null,product VARCHAR(75) null,agentCode VARCHAR(75) null,sourceName VARCHAR(75) null,discount BOOLEAN,createdBy VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table AB_Absli";

	public static final String ORDER_BY_JPQL = " ORDER BY absli.id ASC";

	public static final String ORDER_BY_SQL = " ORDER BY AB_Absli.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long PRODUCT_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SOURCENAME_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UID_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public AbsliModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Absli.class;
	}

	@Override
	public String getModelClassName() {
		return Absli.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Absli, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Absli, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Absli, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Absli)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Absli, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Absli, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept((Absli)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Absli, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Absli, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Absli, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Absli, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Absli, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Absli, Object>>();
		Map<String, BiConsumer<Absli, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Absli, ?>>();

		attributeGetterFunctions.put("uuid", Absli::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Absli, String>)Absli::setUuid);
		attributeGetterFunctions.put("id", Absli::getId);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<Absli, Long>)Absli::setId);
		attributeGetterFunctions.put("groupId", Absli::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Absli, Long>)Absli::setGroupId);
		attributeGetterFunctions.put("companyId", Absli::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Absli, Long>)Absli::setCompanyId);
		attributeGetterFunctions.put("userId", Absli::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Absli, Long>)Absli::setUserId);
		attributeGetterFunctions.put("userName", Absli::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Absli, String>)Absli::setUserName);
		attributeGetterFunctions.put("createDate", Absli::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Absli, Date>)Absli::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Absli::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate", (BiConsumer<Absli, Date>)Absli::setModifiedDate);
		attributeGetterFunctions.put("uId", Absli::getUId);
		attributeSetterBiConsumers.put(
			"uId", (BiConsumer<Absli, String>)Absli::setUId);
		attributeGetterFunctions.put("product", Absli::getProduct);
		attributeSetterBiConsumers.put(
			"product", (BiConsumer<Absli, String>)Absli::setProduct);
		attributeGetterFunctions.put("agentCode", Absli::getAgentCode);
		attributeSetterBiConsumers.put(
			"agentCode", (BiConsumer<Absli, String>)Absli::setAgentCode);
		attributeGetterFunctions.put("sourceName", Absli::getSourceName);
		attributeSetterBiConsumers.put(
			"sourceName", (BiConsumer<Absli, String>)Absli::setSourceName);
		attributeGetterFunctions.put("discount", Absli::getDiscount);
		attributeSetterBiConsumers.put(
			"discount", (BiConsumer<Absli, Boolean>)Absli::setDiscount);
		attributeGetterFunctions.put("createdBy", Absli::getCreatedBy);
		attributeSetterBiConsumers.put(
			"createdBy", (BiConsumer<Absli, String>)Absli::setCreatedBy);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getUId() {
		if (_uId == null) {
			return "";
		}
		else {
			return _uId;
		}
	}

	@Override
	public void setUId(String uId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uId = uId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUId() {
		return getColumnOriginalValue("uId");
	}

	@JSON
	@Override
	public String getProduct() {
		if (_product == null) {
			return "";
		}
		else {
			return _product;
		}
	}

	@Override
	public void setProduct(String product) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_product = product;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalProduct() {
		return getColumnOriginalValue("product");
	}

	@JSON
	@Override
	public String getAgentCode() {
		if (_agentCode == null) {
			return "";
		}
		else {
			return _agentCode;
		}
	}

	@Override
	public void setAgentCode(String agentCode) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_agentCode = agentCode;
	}

	@JSON
	@Override
	public String getSourceName() {
		if (_sourceName == null) {
			return "";
		}
		else {
			return _sourceName;
		}
	}

	@Override
	public void setSourceName(String sourceName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sourceName = sourceName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalSourceName() {
		return getColumnOriginalValue("sourceName");
	}

	@JSON
	@Override
	public boolean getDiscount() {
		return _discount;
	}

	@JSON
	@Override
	public boolean isDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(boolean discount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_discount = discount;
	}

	@JSON
	@Override
	public String getCreatedBy() {
		if (_createdBy == null) {
			return "";
		}
		else {
			return _createdBy;
		}
	}

	@Override
	public void setCreatedBy(String createdBy) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createdBy = createdBy;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(Absli.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Absli.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Absli toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Absli>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AbsliImpl absliImpl = new AbsliImpl();

		absliImpl.setUuid(getUuid());
		absliImpl.setId(getId());
		absliImpl.setGroupId(getGroupId());
		absliImpl.setCompanyId(getCompanyId());
		absliImpl.setUserId(getUserId());
		absliImpl.setUserName(getUserName());
		absliImpl.setCreateDate(getCreateDate());
		absliImpl.setModifiedDate(getModifiedDate());
		absliImpl.setUId(getUId());
		absliImpl.setProduct(getProduct());
		absliImpl.setAgentCode(getAgentCode());
		absliImpl.setSourceName(getSourceName());
		absliImpl.setDiscount(isDiscount());
		absliImpl.setCreatedBy(getCreatedBy());

		absliImpl.resetOriginalValues();

		return absliImpl;
	}

	@Override
	public Absli cloneWithOriginalValues() {
		AbsliImpl absliImpl = new AbsliImpl();

		absliImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		absliImpl.setId(this.<Long>getColumnOriginalValue("id_"));
		absliImpl.setGroupId(this.<Long>getColumnOriginalValue("groupId"));
		absliImpl.setCompanyId(this.<Long>getColumnOriginalValue("companyId"));
		absliImpl.setUserId(this.<Long>getColumnOriginalValue("userId"));
		absliImpl.setUserName(this.<String>getColumnOriginalValue("userName"));
		absliImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		absliImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		absliImpl.setUId(this.<String>getColumnOriginalValue("uId"));
		absliImpl.setProduct(this.<String>getColumnOriginalValue("product"));
		absliImpl.setAgentCode(
			this.<String>getColumnOriginalValue("agentCode"));
		absliImpl.setSourceName(
			this.<String>getColumnOriginalValue("sourceName"));
		absliImpl.setDiscount(this.<Boolean>getColumnOriginalValue("discount"));
		absliImpl.setCreatedBy(
			this.<String>getColumnOriginalValue("createdBy"));

		return absliImpl;
	}

	@Override
	public int compareTo(Absli absli) {
		long primaryKey = absli.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Absli)) {
			return false;
		}

		Absli absli = (Absli)object;

		long primaryKey = absli.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Absli> toCacheModel() {
		AbsliCacheModel absliCacheModel = new AbsliCacheModel();

		absliCacheModel.uuid = getUuid();

		String uuid = absliCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			absliCacheModel.uuid = null;
		}

		absliCacheModel.id = getId();

		absliCacheModel.groupId = getGroupId();

		absliCacheModel.companyId = getCompanyId();

		absliCacheModel.userId = getUserId();

		absliCacheModel.userName = getUserName();

		String userName = absliCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			absliCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			absliCacheModel.createDate = createDate.getTime();
		}
		else {
			absliCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			absliCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			absliCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		absliCacheModel.uId = getUId();

		String uId = absliCacheModel.uId;

		if ((uId != null) && (uId.length() == 0)) {
			absliCacheModel.uId = null;
		}

		absliCacheModel.product = getProduct();

		String product = absliCacheModel.product;

		if ((product != null) && (product.length() == 0)) {
			absliCacheModel.product = null;
		}

		absliCacheModel.agentCode = getAgentCode();

		String agentCode = absliCacheModel.agentCode;

		if ((agentCode != null) && (agentCode.length() == 0)) {
			absliCacheModel.agentCode = null;
		}

		absliCacheModel.sourceName = getSourceName();

		String sourceName = absliCacheModel.sourceName;

		if ((sourceName != null) && (sourceName.length() == 0)) {
			absliCacheModel.sourceName = null;
		}

		absliCacheModel.discount = isDiscount();

		absliCacheModel.createdBy = getCreatedBy();

		String createdBy = absliCacheModel.createdBy;

		if ((createdBy != null) && (createdBy.length() == 0)) {
			absliCacheModel.createdBy = null;
		}

		return absliCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Absli, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Absli, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Absli, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Absli)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Absli, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Absli, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Absli, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Absli)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Absli>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Absli.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _uId;
	private String _product;
	private String _agentCode;
	private String _sourceName;
	private boolean _discount;
	private String _createdBy;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Absli, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Absli)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("uId", _uId);
		_columnOriginalValues.put("product", _product);
		_columnOriginalValues.put("agentCode", _agentCode);
		_columnOriginalValues.put("sourceName", _sourceName);
		_columnOriginalValues.put("discount", _discount);
		_columnOriginalValues.put("createdBy", _createdBy);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");
		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("id_", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("uId", 256L);

		columnBitmasks.put("product", 512L);

		columnBitmasks.put("agentCode", 1024L);

		columnBitmasks.put("sourceName", 2048L);

		columnBitmasks.put("discount", 4096L);

		columnBitmasks.put("createdBy", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Absli _escapedModel;

}