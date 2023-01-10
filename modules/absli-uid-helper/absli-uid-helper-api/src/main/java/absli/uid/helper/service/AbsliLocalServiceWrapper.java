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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AbsliLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AbsliLocalService
 * @generated
 */
public class AbsliLocalServiceWrapper
	implements AbsliLocalService, ServiceWrapper<AbsliLocalService> {

	public AbsliLocalServiceWrapper() {
		this(null);
	}

	public AbsliLocalServiceWrapper(AbsliLocalService absliLocalService) {
		_absliLocalService = absliLocalService;
	}

	@Override
	public absli.uid.helper.model.Absli add(
			long userId, String productName, String uid, String agentCode,
			String sourceName, boolean discount, String createdBy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.add(
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
	@Override
	public absli.uid.helper.model.Absli addAbsli(
		absli.uid.helper.model.Absli absli) {

		return _absliLocalService.addAbsli(absli);
	}

	/**
	 * Creates a new absli with the primary key. Does not add the absli to the database.
	 *
	 * @param id the primary key for the new absli
	 * @return the new absli
	 */
	@Override
	public absli.uid.helper.model.Absli createAbsli(long id) {
		return _absliLocalService.createAbsli(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public absli.uid.helper.model.Absli deleteAbsli(
		absli.uid.helper.model.Absli absli) {

		return _absliLocalService.deleteAbsli(absli);
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
	@Override
	public absli.uid.helper.model.Absli deleteAbsli(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.deleteAbsli(id);
	}

	@Override
	public absli.uid.helper.model.Absli deleteAbsli(String uId) {
		return _absliLocalService.deleteAbsli(uId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _absliLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _absliLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _absliLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _absliLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _absliLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _absliLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _absliLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _absliLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public absli.uid.helper.model.Absli fetchAbsli(long id) {
		return _absliLocalService.fetchAbsli(id);
	}

	/**
	 * Returns the absli matching the UUID and group.
	 *
	 * @param uuid the absli's UUID
	 * @param groupId the primary key of the group
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public absli.uid.helper.model.Absli fetchAbsliByUuidAndGroupId(
		String uuid, long groupId) {

		return _absliLocalService.fetchAbsliByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the absli with the primary key.
	 *
	 * @param id the primary key of the absli
	 * @return the absli
	 * @throws PortalException if a absli with the primary key could not be found
	 */
	@Override
	public absli.uid.helper.model.Absli getAbsli(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.getAbsli(id);
	}

	/**
	 * Returns the absli matching the UUID and group.
	 *
	 * @param uuid the absli's UUID
	 * @param groupId the primary key of the group
	 * @return the matching absli
	 * @throws PortalException if a matching absli could not be found
	 */
	@Override
	public absli.uid.helper.model.Absli getAbsliByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.getAbsliByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<absli.uid.helper.model.Absli> getAbslis(
		int start, int end) {

		return _absliLocalService.getAbslis(start, end);
	}

	/**
	 * Returns all the abslis matching the UUID and company.
	 *
	 * @param uuid the UUID of the abslis
	 * @param companyId the primary key of the company
	 * @return the matching abslis, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<absli.uid.helper.model.Absli>
		getAbslisByUuidAndCompanyId(String uuid, long companyId) {

		return _absliLocalService.getAbslisByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<absli.uid.helper.model.Absli>
		getAbslisByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<absli.uid.helper.model.Absli> orderByComparator) {

		return _absliLocalService.getAbslisByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of abslis.
	 *
	 * @return the number of abslis
	 */
	@Override
	public int getAbslisCount() {
		return _absliLocalService.getAbslisCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _absliLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<absli.uid.helper.model.Absli> getAll(long groupId) {
		return _absliLocalService.getAll(groupId);
	}

	@Override
	public absli.uid.helper.model.Absli getbyUid(String uId) {
		return _absliLocalService.getbyUid(uId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _absliLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _absliLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _absliLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public absli.uid.helper.model.Absli update(
			long userId, long id, String productName, String uid,
			String agentCode, String sourceName, boolean discount,
			String createdBy,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _absliLocalService.update(
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
	@Override
	public absli.uid.helper.model.Absli updateAbsli(
		absli.uid.helper.model.Absli absli) {

		return _absliLocalService.updateAbsli(absli);
	}

	@Override
	public AbsliLocalService getWrappedService() {
		return _absliLocalService;
	}

	@Override
	public void setWrappedService(AbsliLocalService absliLocalService) {
		_absliLocalService = absliLocalService;
	}

	private AbsliLocalService _absliLocalService;

}