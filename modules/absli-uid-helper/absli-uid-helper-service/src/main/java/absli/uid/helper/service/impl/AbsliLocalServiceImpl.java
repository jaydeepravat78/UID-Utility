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

package absli.uid.helper.service.impl;

import absli.uid.helper.model.Absli;
import absli.uid.helper.service.base.AbsliLocalServiceBaseImpl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=absli.uid.helper.model.Absli",
	service = AopService.class
)
public class AbsliLocalServiceImpl extends AbsliLocalServiceBaseImpl {
	public Absli add(long userId, String productName, String uid,
					 String agentCode, String sourceName, boolean discount, String createdBy, ServiceContext serviceContext) throws PortalException {

		long id = counterLocalService.increment();
		Absli absli =  absliPersistence.create(id);
		User user = userLocalService.getUserById(userId);
		long groupId = serviceContext.getScopeGroupId();
		Date now = new Date();
		absli.setUuid(serviceContext.getUuid());
		absli.setUserId(userId);
		absli.setGroupId(groupId);
		absli.setCompanyId(user.getCompanyId());
		absli.setUserName(user.getFullName());
		absli.setCreateDate(serviceContext.getCreateDate(now));
		absli.setModifiedDate(serviceContext.getModifiedDate(now));
		absli.setExpandoBridgeAttributes(serviceContext);
		absli.setUId(uid);
		absli.setProduct(productName);
		absli.setAgentCode(agentCode);
		absli.setSourceName(sourceName);
		absli.setDiscount(discount);
		absli.setCreatedBy(createdBy);
		absliPersistence.update(absli);
		return absli;
	}

	public List<Absli> getAll(long groupId) {
		return absliPersistence.findByGroupId(groupId);
	}

	public Absli getbyUid(String uId) {
		return absliPersistence.findByUid(uId).get(0);
	}

	public Absli deleteAbsli(String uId) {
		Absli absli = getbyUid(uId);
		return absliPersistence.remove(absli);
	}

	public Absli update(long userId,long id, String productName, String uid,
						String agentCode, String sourceName, boolean discount, String createdBy, ServiceContext serviceContext ) throws PortalException {
		Absli absli =  getAbsli(id);
		User user = userLocalService.getUserById(userId);
		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();
		absli.setUuid(serviceContext.getUuid());
		absli.setUserId(userId);
		absli.setGroupId(groupId);
		absli.setCompanyId(user.getCompanyId());
		absli.setUserName(user.getFullName());
		absli.setCreateDate(serviceContext.getCreateDate(now));
		absli.setModifiedDate(serviceContext.getModifiedDate(now));
		absli.setExpandoBridgeAttributes(serviceContext);
		absli.setUId(uid);
		absli.setProduct(productName);
		absli.setAgentCode(agentCode);
		absli.setSourceName(sourceName);
		absli.setDiscount(discount);
		absli.setCreatedBy(createdBy);
		absliPersistence.update(absli);
		return absli;
	}

}