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

package absli.uid.helper.service.persistence;

import absli.uid.helper.model.Absli;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the absli service. This utility wraps <code>absli.uid.helper.service.persistence.impl.AbsliPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AbsliPersistence
 * @generated
 */
public class AbsliUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Absli absli) {
		getPersistence().clearCache(absli);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Absli> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Absli> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Absli> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Absli> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Absli update(Absli absli) {
		return getPersistence().update(absli);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Absli update(Absli absli, ServiceContext serviceContext) {
		return getPersistence().update(absli, serviceContext);
	}

	/**
	 * Returns all the abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abslis
	 */
	public static List<Absli> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the abslis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of matching abslis
	 */
	public static List<Absli> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the abslis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUuid_First(
			String uuid, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUuid_First(
		String uuid, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUuid_Last(
			String uuid, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUuid_Last(
		String uuid, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the abslis before and after the current absli in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the abslis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abslis
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUUID_G(String uuid, long groupId)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the absli where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the absli that was removed
	 */
	public static Absli removeByUUID_G(String uuid, long groupId)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of abslis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching abslis
	 */
	public static List<Absli> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of matching abslis
	 */
	public static List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the abslis before and after the current absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the abslis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching abslis
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching abslis
	 */
	public static List<Absli> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the abslis where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of matching abslis
	 */
	public static List<Absli> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the abslis where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByGroupId_First(
			long groupId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByGroupId_First(
		long groupId, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByGroupId_Last(
			long groupId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByGroupId_Last(
		long groupId, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the abslis before and after the current absli in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli[] findByGroupId_PrevAndNext(
			long id, long groupId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the abslis where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the matching abslis
	 */
	public static List<Absli> findByProduct(String product) {
		return getPersistence().findByProduct(product);
	}

	/**
	 * Returns a range of all the abslis where product = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param product the product
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of matching abslis
	 */
	public static List<Absli> findByProduct(
		String product, int start, int end) {

		return getPersistence().findByProduct(product, start, end);
	}

	/**
	 * Returns an ordered range of all the abslis where product = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param product the product
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByProduct(
		String product, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findByProduct(
			product, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis where product = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param product the product
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByProduct(
		String product, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByProduct(
			product, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByProduct_First(
			String product, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByProduct_First(product, orderByComparator);
	}

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByProduct_First(
		String product, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByProduct_First(
			product, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByProduct_Last(
			String product, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByProduct_Last(product, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByProduct_Last(
		String product, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByProduct_Last(product, orderByComparator);
	}

	/**
	 * Returns the abslis before and after the current absli in the ordered set where product = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli[] findByProduct_PrevAndNext(
			long id, String product, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByProduct_PrevAndNext(
			id, product, orderByComparator);
	}

	/**
	 * Removes all the abslis where product = &#63; from the database.
	 *
	 * @param product the product
	 */
	public static void removeByProduct(String product) {
		getPersistence().removeByProduct(product);
	}

	/**
	 * Returns the number of abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the number of matching abslis
	 */
	public static int countByProduct(String product) {
		return getPersistence().countByProduct(product);
	}

	/**
	 * Returns all the abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the matching abslis
	 */
	public static List<Absli> findByUid(String uId) {
		return getPersistence().findByUid(uId);
	}

	/**
	 * Returns a range of all the abslis where uId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uId the u ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of matching abslis
	 */
	public static List<Absli> findByUid(String uId, int start, int end) {
		return getPersistence().findByUid(uId, start, end);
	}

	/**
	 * Returns an ordered range of all the abslis where uId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uId the u ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUid(
		String uId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findByUid(uId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis where uId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param uId the u ID
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching abslis
	 */
	public static List<Absli> findByUid(
		String uId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUid(
			uId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUid_First(
			String uId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUid_First(uId, orderByComparator);
	}

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUid_First(
		String uId, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUid_First(uId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findByUid_Last(
			String uId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUid_Last(uId, orderByComparator);
	}

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchByUid_Last(
		String uId, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().fetchByUid_Last(uId, orderByComparator);
	}

	/**
	 * Returns the abslis before and after the current absli in the ordered set where uId = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli[] findByUid_PrevAndNext(
			long id, String uId, OrderByComparator<Absli> orderByComparator)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByUid_PrevAndNext(
			id, uId, orderByComparator);
	}

	/**
	 * Removes all the abslis where uId = &#63; from the database.
	 *
	 * @param uId the u ID
	 */
	public static void removeByUid(String uId) {
		getPersistence().removeByUid(uId);
	}

	/**
	 * Returns the number of abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the number of matching abslis
	 */
	public static int countByUid(String uId) {
		return getPersistence().countByUid(uId);
	}

	/**
	 * Returns the absli where sourceName = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param sourceName the source name
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public static Absli findBySourceName(String sourceName)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findBySourceName(sourceName);
	}

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceName the source name
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchBySourceName(String sourceName) {
		return getPersistence().fetchBySourceName(sourceName);
	}

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceName the source name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchBySourceName(
		String sourceName, boolean useFinderCache) {

		return getPersistence().fetchBySourceName(sourceName, useFinderCache);
	}

	/**
	 * Removes the absli where sourceName = &#63; from the database.
	 *
	 * @param sourceName the source name
	 * @return the absli that was removed
	 */
	public static Absli removeBySourceName(String sourceName)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().removeBySourceName(sourceName);
	}

	/**
	 * Returns the number of abslis where sourceName = &#63;.
	 *
	 * @param sourceName the source name
	 * @return the number of matching abslis
	 */
	public static int countBySourceName(String sourceName) {
		return getPersistence().countBySourceName(sourceName);
	}

	/**
	 * Caches the absli in the entity cache if it is enabled.
	 *
	 * @param absli the absli
	 */
	public static void cacheResult(Absli absli) {
		getPersistence().cacheResult(absli);
	}

	/**
	 * Caches the abslis in the entity cache if it is enabled.
	 *
	 * @param abslis the abslis
	 */
	public static void cacheResult(List<Absli> abslis) {
		getPersistence().cacheResult(abslis);
	}

	/**
	 * Creates a new absli with the primary key. Does not add the absli to the database.
	 *
	 * @param id the primary key for the new absli
	 * @return the new absli
	 */
	public static Absli create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the absli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the absli
	 * @return the absli that was removed
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli remove(long id)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().remove(id);
	}

	public static Absli updateImpl(Absli absli) {
		return getPersistence().updateImpl(absli);
	}

	/**
	 * Returns the absli with the primary key or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public static Absli findByPrimaryKey(long id)
		throws absli.uid.helper.exception.NoSuchAbsliException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the absli with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli, or <code>null</code> if a absli with the primary key could not be found
	 */
	public static Absli fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the abslis.
	 *
	 * @return the abslis
	 */
	public static List<Absli> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the abslis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of abslis
	 */
	public static List<Absli> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the abslis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of abslis
	 */
	public static List<Absli> findAll(
		int start, int end, OrderByComparator<Absli> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the abslis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of abslis
	 */
	public static List<Absli> findAll(
		int start, int end, OrderByComparator<Absli> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the abslis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of abslis.
	 *
	 * @return the number of abslis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AbsliPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AbsliPersistence _persistence;

}