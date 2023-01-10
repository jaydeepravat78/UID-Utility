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

import absli.uid.helper.exception.NoSuchAbsliException;
import absli.uid.helper.model.Absli;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the absli service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AbsliUtil
 * @generated
 */
@ProviderType
public interface AbsliPersistence extends BasePersistence<Absli> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AbsliUtil} to access the absli persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abslis
	 */
	public java.util.List<Absli> findByUuid(String uuid);

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
	public java.util.List<Absli> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Absli> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the abslis before and after the current absli in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Removes all the abslis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abslis
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUUID_G(String uuid, long groupId)
		throws NoSuchAbsliException;

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the absli where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the absli that was removed
	 */
	public Absli removeByUUID_G(String uuid, long groupId)
		throws NoSuchAbsliException;

	/**
	 * Returns the number of abslis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching abslis
	 */
	public java.util.List<Absli> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the first absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the last absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the last absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public Absli[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Removes all the abslis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching abslis
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching abslis
	 */
	public java.util.List<Absli> findByGroupId(long groupId);

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
	public java.util.List<Absli> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Absli> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the abslis before and after the current absli in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli[] findByGroupId_PrevAndNext(
			long id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Removes all the abslis where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the matching abslis
	 */
	public java.util.List<Absli> findByProduct(String product);

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
	public java.util.List<Absli> findByProduct(
		String product, int start, int end);

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
	public java.util.List<Absli> findByProduct(
		String product, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findByProduct(
		String product, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByProduct_First(
			String product,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByProduct_First(
		String product,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByProduct_Last(
			String product,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByProduct_Last(
		String product,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the abslis before and after the current absli in the ordered set where product = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli[] findByProduct_PrevAndNext(
			long id, String product,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Removes all the abslis where product = &#63; from the database.
	 *
	 * @param product the product
	 */
	public void removeByProduct(String product);

	/**
	 * Returns the number of abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the number of matching abslis
	 */
	public int countByProduct(String product);

	/**
	 * Returns all the abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the matching abslis
	 */
	public java.util.List<Absli> findByUid(String uId);

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
	public java.util.List<Absli> findByUid(String uId, int start, int end);

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
	public java.util.List<Absli> findByUid(
		String uId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findByUid(
		String uId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUid_First(
			String uId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUid_First(
		String uId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findByUid_Last(
			String uId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchByUid_Last(
		String uId,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

	/**
	 * Returns the abslis before and after the current absli in the ordered set where uId = &#63;.
	 *
	 * @param id the primary key of the current absli
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli[] findByUid_PrevAndNext(
			long id, String uId,
			com.liferay.portal.kernel.util.OrderByComparator<Absli>
				orderByComparator)
		throws NoSuchAbsliException;

	/**
	 * Removes all the abslis where uId = &#63; from the database.
	 *
	 * @param uId the u ID
	 */
	public void removeByUid(String uId);

	/**
	 * Returns the number of abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the number of matching abslis
	 */
	public int countByUid(String uId);

	/**
	 * Returns the absli where sourceName = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param sourceName the source name
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	public Absli findBySourceName(String sourceName)
		throws NoSuchAbsliException;

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceName the source name
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchBySourceName(String sourceName);

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceName the source name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	public Absli fetchBySourceName(String sourceName, boolean useFinderCache);

	/**
	 * Removes the absli where sourceName = &#63; from the database.
	 *
	 * @param sourceName the source name
	 * @return the absli that was removed
	 */
	public Absli removeBySourceName(String sourceName)
		throws NoSuchAbsliException;

	/**
	 * Returns the number of abslis where sourceName = &#63;.
	 *
	 * @param sourceName the source name
	 * @return the number of matching abslis
	 */
	public int countBySourceName(String sourceName);

	/**
	 * Caches the absli in the entity cache if it is enabled.
	 *
	 * @param absli the absli
	 */
	public void cacheResult(Absli absli);

	/**
	 * Caches the abslis in the entity cache if it is enabled.
	 *
	 * @param abslis the abslis
	 */
	public void cacheResult(java.util.List<Absli> abslis);

	/**
	 * Creates a new absli with the primary key. Does not add the absli to the database.
	 *
	 * @param id the primary key for the new absli
	 * @return the new absli
	 */
	public Absli create(long id);

	/**
	 * Removes the absli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the absli
	 * @return the absli that was removed
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli remove(long id) throws NoSuchAbsliException;

	public Absli updateImpl(Absli absli);

	/**
	 * Returns the absli with the primary key or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	public Absli findByPrimaryKey(long id) throws NoSuchAbsliException;

	/**
	 * Returns the absli with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli, or <code>null</code> if a absli with the primary key could not be found
	 */
	public Absli fetchByPrimaryKey(long id);

	/**
	 * Returns all the abslis.
	 *
	 * @return the abslis
	 */
	public java.util.List<Absli> findAll();

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
	public java.util.List<Absli> findAll(int start, int end);

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
	public java.util.List<Absli> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator);

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
	public java.util.List<Absli> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Absli>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the abslis from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of abslis.
	 *
	 * @return the number of abslis
	 */
	public int countAll();

}