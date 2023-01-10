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

package absli.uid.helper.service;

import absli.uid.helper.model.Absli;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Absli. This utility wraps
 * <code>absli.uid.helper.service.impl.AbsliLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AbsliLocalService
 * @generated
 */
public class AbsliLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>absli.uid.helper.service.impl.AbsliLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Absli add(
			long userId, String productName, String uid, String agentCode,
			String sourceName, boolean discount, String createdBy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().add(
			userId, productName, uid, agentCode, sourceName, discount,
			createdBy, serviceContext);
	}

	/**
	 * Adds the absli to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbsliLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param absli the absli
	 * @return the absli that was added
	 */
	public static Absli addAbsli(Absli absli) {
		return getService().addAbsli(absli);
	}

	/**
	 * Creates a new absli with the primary key. Does not add the absli to the database.
	 *
	 * @param id the primary key for the new absli
	 * @return the new absli
	 */
	public static Absli createAbsli(long id) {
		return getService().createAbsli(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the absli from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbsliLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param absli the absli
	 * @return the absli that was removed
	 */
	public static Absli deleteAbsli(Absli absli) {
		return getService().deleteAbsli(absli);
	}

	/**
	 * Deletes the absli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbsliLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the absli
	 * @return the absli that was removed
	 * @throws PortalException if a absli with the primary key could not be found
	 */
	public static Absli deleteAbsli(long id) throws PortalException {
		return getService().deleteAbsli(id);
	}

	public static Absli deleteAbsli(String uId) {
		return getService().deleteAbsli(uId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>absli.uid.helper.model.impl.AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>absli.uid.helper.model.impl.AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Absli fetchAbsli(long id) {
		return getService().fetchAbsli(id);
	}

	/**
	 * Returns the absli matching the UUID and group.
	 *
	 * @param uuid the absli's UUID
	 * @param groupId the primary key of the group
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public static Absli fetchAbsliByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchAbsliByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the absli with the primary key.
	 *
	 * @param id the primary key of the absli
	 * @return the absli
	 * @throws PortalException if a absli with the primary key could not be found
	 */
	public static Absli getAbsli(long id) throws PortalException {
		return getService().getAbsli(id);
	}

	/**
	 * Returns the absli matching the UUID and group.
	 *
	 * @param uuid the absli's UUID
	 * @param groupId the primary key of the group
	 * @return the matching absli
	 * @throws PortalException if a matching absli could not be found
	 */
	public static Absli getAbsliByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAbsliByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the abslis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>absli.uid.helper.model.impl.AbsliModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @return the range of abslis
	 */
	public static List<Absli> getAbslis(int start, int end) {
		return getService().getAbslis(start, end);
	}

	/**
	 * Returns all the abslis matching the UUID and company.
	 *
	 * @param uuid the UUID of the abslis
	 * @param companyId the primary key of the company
	 * @return the matching abslis, or an empty list if no matches were found
	 */
	public static List<Absli> getAbslisByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAbslisByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of abslis matching the UUID and company.
	 *
	 * @param uuid the UUID of the abslis
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of abslis
	 * @param end the upper bound of the range of abslis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching abslis, or an empty list if no matches were found
	 */
	public static List<Absli> getAbslisByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return getService().getAbslisByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of abslis.
	 *
	 * @return the number of abslis
	 */
	public static int getAbslisCount() {
		return getService().getAbslisCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<Absli> getAll(long groupId) {
		return getService().getAll(groupId);
	}

	public static Absli getbyUid(String uId) {
		return getService().getbyUid(uId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static Absli update(
			long userId, long id, String productName, String uid,
			String agentCode, String sourceName, boolean discount,
			String createdBy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().update(
			userId, id, productName, uid, agentCode, sourceName, discount,
			createdBy, serviceContext);
	}

	/**
	 * Updates the absli in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AbsliLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param absli the absli
	 * @return the absli that was updated
	 */
	public static Absli updateAbsli(Absli absli) {
		return getService().updateAbsli(absli);
	}

	public static AbsliLocalService getService() {
		return _service;
	}

	private static volatile AbsliLocalService _service;

}