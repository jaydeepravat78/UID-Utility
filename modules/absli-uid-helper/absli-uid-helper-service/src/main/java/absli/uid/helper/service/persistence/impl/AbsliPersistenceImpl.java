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

package absli.uid.helper.service.persistence.impl;

import absli.uid.helper.exception.NoSuchAbsliException;
import absli.uid.helper.model.Absli;
import absli.uid.helper.model.AbsliTable;
import absli.uid.helper.model.impl.AbsliImpl;
import absli.uid.helper.model.impl.AbsliModelImpl;
import absli.uid.helper.service.persistence.AbsliPersistence;
import absli.uid.helper.service.persistence.AbsliUtil;
import absli.uid.helper.service.persistence.impl.constants.ABPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the absli service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {AbsliPersistence.class, BasePersistence.class})
public class AbsliPersistenceImpl
	extends BasePersistenceImpl<Absli> implements AbsliPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AbsliUtil</code> to access the absli persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AbsliImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching abslis
	 */
	@Override
	public List<Absli> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Absli> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Absli absli : list) {
					if (!uuid.equals(absli.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbsliModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByUuid_First(
			String uuid, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUuid_First(uuid, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUuid_First(
		String uuid, OrderByComparator<Absli> orderByComparator) {

		List<Absli> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByUuid_Last(
			String uuid, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUuid_Last(uuid, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUuid_Last(
		String uuid, OrderByComparator<Absli> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Absli> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		uuid = Objects.toString(uuid, "");

		Absli absli = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Absli[] array = new AbsliImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, absli, uuid, orderByComparator, true);

			array[1] = absli;

			array[2] = getByUuid_PrevAndNext(
				session, absli, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Absli getByUuid_PrevAndNext(
		Session session, Absli absli, String uuid,
		OrderByComparator<Absli> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABSLI_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AbsliModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(absli)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Absli> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abslis where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Absli absli :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching abslis
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "absli.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(absli.uuid IS NULL OR absli.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByUUID_G(String uuid, long groupId)
		throws NoSuchAbsliException {

		Absli absli = fetchByUUID_G(uuid, groupId);

		if (absli == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAbsliException(sb.toString());
		}

		return absli;
	}

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the absli where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof Absli) {
			Absli absli = (Absli)result;

			if (!Objects.equals(uuid, absli.getUuid()) ||
				(groupId != absli.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Absli> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Absli absli = list.get(0);

					result = absli;

					cacheResult(absli);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Absli)result;
		}
	}

	/**
	 * Removes the absli where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the absli that was removed
	 */
	@Override
	public Absli removeByUUID_G(String uuid, long groupId)
		throws NoSuchAbsliException {

		Absli absli = findByUUID_G(uuid, groupId);

		return remove(absli);
	}

	/**
	 * Returns the number of abslis where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"absli.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(absli.uuid IS NULL OR absli.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"absli.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching abslis
	 */
	@Override
	public List<Absli> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Absli absli : list) {
					if (!uuid.equals(absli.getUuid()) ||
						(companyId != absli.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbsliModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Absli findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the first absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Absli> orderByComparator) {

		List<Absli> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the last absli in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Absli> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Absli> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		uuid = Objects.toString(uuid, "");

		Absli absli = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Absli[] array = new AbsliImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, absli, uuid, companyId, orderByComparator, true);

			array[1] = absli;

			array[2] = getByUuid_C_PrevAndNext(
				session, absli, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Absli getByUuid_C_PrevAndNext(
		Session session, Absli absli, String uuid, long companyId,
		OrderByComparator<Absli> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ABSLI_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AbsliModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(absli)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Absli> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abslis where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Absli absli :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching abslis
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"absli.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(absli.uuid IS NULL OR absli.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"absli.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching abslis
	 */
	@Override
	public List<Absli> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Absli> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Absli absli : list) {
					if (groupId != absli.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbsliModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByGroupId_First(
			long groupId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByGroupId_First(groupId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the first absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByGroupId_First(
		long groupId, OrderByComparator<Absli> orderByComparator) {

		List<Absli> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByGroupId_Last(
			long groupId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByGroupId_Last(groupId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the last absli in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByGroupId_Last(
		long groupId, OrderByComparator<Absli> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Absli> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli[] findByGroupId_PrevAndNext(
			long id, long groupId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Absli[] array = new AbsliImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, absli, groupId, orderByComparator, true);

			array[1] = absli;

			array[2] = getByGroupId_PrevAndNext(
				session, absli, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Absli getByGroupId_PrevAndNext(
		Session session, Absli absli, long groupId,
		OrderByComparator<Absli> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABSLI_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AbsliModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(absli)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Absli> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abslis where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Absli absli :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching abslis
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"absli.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByProduct;
	private FinderPath _finderPathWithoutPaginationFindByProduct;
	private FinderPath _finderPathCountByProduct;

	/**
	 * Returns all the abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the matching abslis
	 */
	@Override
	public List<Absli> findByProduct(String product) {
		return findByProduct(
			product, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findByProduct(String product, int start, int end) {
		return findByProduct(product, start, end, null);
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
	@Override
	public List<Absli> findByProduct(
		String product, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return findByProduct(product, start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findByProduct(
		String product, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		product = Objects.toString(product, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProduct;
				finderArgs = new Object[] {product};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProduct;
			finderArgs = new Object[] {product, start, end, orderByComparator};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Absli absli : list) {
					if (!product.equals(absli.getProduct())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindProduct = false;

			if (product.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_3);
			}
			else {
				bindProduct = true;

				sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbsliModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProduct) {
					queryPos.add(product);
				}

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByProduct_First(
			String product, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByProduct_First(product, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("product=");
		sb.append(product);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the first absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByProduct_First(
		String product, OrderByComparator<Absli> orderByComparator) {

		List<Absli> list = findByProduct(product, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByProduct_Last(
			String product, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByProduct_Last(product, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("product=");
		sb.append(product);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the last absli in the ordered set where product = &#63;.
	 *
	 * @param product the product
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByProduct_Last(
		String product, OrderByComparator<Absli> orderByComparator) {

		int count = countByProduct(product);

		if (count == 0) {
			return null;
		}

		List<Absli> list = findByProduct(
			product, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli[] findByProduct_PrevAndNext(
			long id, String product, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		product = Objects.toString(product, "");

		Absli absli = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Absli[] array = new AbsliImpl[3];

			array[0] = getByProduct_PrevAndNext(
				session, absli, product, orderByComparator, true);

			array[1] = absli;

			array[2] = getByProduct_PrevAndNext(
				session, absli, product, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Absli getByProduct_PrevAndNext(
		Session session, Absli absli, String product,
		OrderByComparator<Absli> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABSLI_WHERE);

		boolean bindProduct = false;

		if (product.isEmpty()) {
			sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_3);
		}
		else {
			bindProduct = true;

			sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AbsliModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindProduct) {
			queryPos.add(product);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(absli)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Absli> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abslis where product = &#63; from the database.
	 *
	 * @param product the product
	 */
	@Override
	public void removeByProduct(String product) {
		for (Absli absli :
				findByProduct(
					product, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis where product = &#63;.
	 *
	 * @param product the product
	 * @return the number of matching abslis
	 */
	@Override
	public int countByProduct(String product) {
		product = Objects.toString(product, "");

		FinderPath finderPath = _finderPathCountByProduct;

		Object[] finderArgs = new Object[] {product};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindProduct = false;

			if (product.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_3);
			}
			else {
				bindProduct = true;

				sb.append(_FINDER_COLUMN_PRODUCT_PRODUCT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProduct) {
					queryPos.add(product);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCT_PRODUCT_2 =
		"absli.product = ?";

	private static final String _FINDER_COLUMN_PRODUCT_PRODUCT_3 =
		"(absli.product IS NULL OR absli.product = '')";

	private FinderPath _finderPathWithPaginationFindByUid;
	private FinderPath _finderPathWithoutPaginationFindByUid;
	private FinderPath _finderPathCountByUid;

	/**
	 * Returns all the abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the matching abslis
	 */
	@Override
	public List<Absli> findByUid(String uId) {
		return findByUid(uId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findByUid(String uId, int start, int end) {
		return findByUid(uId, start, end, null);
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
	@Override
	public List<Absli> findByUid(
		String uId, int start, int end,
		OrderByComparator<Absli> orderByComparator) {

		return findByUid(uId, start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findByUid(
		String uId, int start, int end,
		OrderByComparator<Absli> orderByComparator, boolean useFinderCache) {

		uId = Objects.toString(uId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUid;
				finderArgs = new Object[] {uId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUid;
			finderArgs = new Object[] {uId, start, end, orderByComparator};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Absli absli : list) {
					if (!uId.equals(absli.getUId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindUId = false;

			if (uId.isEmpty()) {
				sb.append(_FINDER_COLUMN_UID_UID_3);
			}
			else {
				bindUId = true;

				sb.append(_FINDER_COLUMN_UID_UID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AbsliModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUId) {
					queryPos.add(uId);
				}

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByUid_First(
			String uId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUid_First(uId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uId=");
		sb.append(uId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the first absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUid_First(
		String uId, OrderByComparator<Absli> orderByComparator) {

		List<Absli> list = findByUid(uId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findByUid_Last(
			String uId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		Absli absli = fetchByUid_Last(uId, orderByComparator);

		if (absli != null) {
			return absli;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uId=");
		sb.append(uId);

		sb.append("}");

		throw new NoSuchAbsliException(sb.toString());
	}

	/**
	 * Returns the last absli in the ordered set where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchByUid_Last(
		String uId, OrderByComparator<Absli> orderByComparator) {

		int count = countByUid(uId);

		if (count == 0) {
			return null;
		}

		List<Absli> list = findByUid(uId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Absli[] findByUid_PrevAndNext(
			long id, String uId, OrderByComparator<Absli> orderByComparator)
		throws NoSuchAbsliException {

		uId = Objects.toString(uId, "");

		Absli absli = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Absli[] array = new AbsliImpl[3];

			array[0] = getByUid_PrevAndNext(
				session, absli, uId, orderByComparator, true);

			array[1] = absli;

			array[2] = getByUid_PrevAndNext(
				session, absli, uId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Absli getByUid_PrevAndNext(
		Session session, Absli absli, String uId,
		OrderByComparator<Absli> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ABSLI_WHERE);

		boolean bindUId = false;

		if (uId.isEmpty()) {
			sb.append(_FINDER_COLUMN_UID_UID_3);
		}
		else {
			bindUId = true;

			sb.append(_FINDER_COLUMN_UID_UID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AbsliModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUId) {
			queryPos.add(uId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(absli)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Absli> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the abslis where uId = &#63; from the database.
	 *
	 * @param uId the u ID
	 */
	@Override
	public void removeByUid(String uId) {
		for (Absli absli :
				findByUid(uId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis where uId = &#63;.
	 *
	 * @param uId the u ID
	 * @return the number of matching abslis
	 */
	@Override
	public int countByUid(String uId) {
		uId = Objects.toString(uId, "");

		FinderPath finderPath = _finderPathCountByUid;

		Object[] finderArgs = new Object[] {uId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindUId = false;

			if (uId.isEmpty()) {
				sb.append(_FINDER_COLUMN_UID_UID_3);
			}
			else {
				bindUId = true;

				sb.append(_FINDER_COLUMN_UID_UID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUId) {
					queryPos.add(uId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UID_UID_2 = "absli.uId = ?";

	private static final String _FINDER_COLUMN_UID_UID_3 =
		"(absli.uId IS NULL OR absli.uId = '')";

	private FinderPath _finderPathFetchBySourceName;
	private FinderPath _finderPathCountBySourceName;

	/**
	 * Returns the absli where sourceName = &#63; or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param sourceName the source name
	 * @return the matching absli
	 * @throws NoSuchAbsliException if a matching absli could not be found
	 */
	@Override
	public Absli findBySourceName(String sourceName)
		throws NoSuchAbsliException {

		Absli absli = fetchBySourceName(sourceName);

		if (absli == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sourceName=");
			sb.append(sourceName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAbsliException(sb.toString());
		}

		return absli;
	}

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceName the source name
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchBySourceName(String sourceName) {
		return fetchBySourceName(sourceName, true);
	}

	/**
	 * Returns the absli where sourceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceName the source name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching absli, or <code>null</code> if a matching absli could not be found
	 */
	@Override
	public Absli fetchBySourceName(String sourceName, boolean useFinderCache) {
		sourceName = Objects.toString(sourceName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sourceName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySourceName, finderArgs);
		}

		if (result instanceof Absli) {
			Absli absli = (Absli)result;

			if (!Objects.equals(sourceName, absli.getSourceName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ABSLI_WHERE);

			boolean bindSourceName = false;

			if (sourceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCENAME_SOURCENAME_3);
			}
			else {
				bindSourceName = true;

				sb.append(_FINDER_COLUMN_SOURCENAME_SOURCENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceName) {
					queryPos.add(sourceName);
				}

				List<Absli> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySourceName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {sourceName};
							}

							_log.warn(
								"AbsliPersistenceImpl.fetchBySourceName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Absli absli = list.get(0);

					result = absli;

					cacheResult(absli);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Absli)result;
		}
	}

	/**
	 * Removes the absli where sourceName = &#63; from the database.
	 *
	 * @param sourceName the source name
	 * @return the absli that was removed
	 */
	@Override
	public Absli removeBySourceName(String sourceName)
		throws NoSuchAbsliException {

		Absli absli = findBySourceName(sourceName);

		return remove(absli);
	}

	/**
	 * Returns the number of abslis where sourceName = &#63;.
	 *
	 * @param sourceName the source name
	 * @return the number of matching abslis
	 */
	@Override
	public int countBySourceName(String sourceName) {
		sourceName = Objects.toString(sourceName, "");

		FinderPath finderPath = _finderPathCountBySourceName;

		Object[] finderArgs = new Object[] {sourceName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ABSLI_WHERE);

			boolean bindSourceName = false;

			if (sourceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCENAME_SOURCENAME_3);
			}
			else {
				bindSourceName = true;

				sb.append(_FINDER_COLUMN_SOURCENAME_SOURCENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceName) {
					queryPos.add(sourceName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SOURCENAME_SOURCENAME_2 =
		"absli.sourceName = ?";

	private static final String _FINDER_COLUMN_SOURCENAME_SOURCENAME_3 =
		"(absli.sourceName IS NULL OR absli.sourceName = '')";

	public AbsliPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Absli.class);

		setModelImplClass(AbsliImpl.class);
		setModelPKClass(long.class);

		setTable(AbsliTable.INSTANCE);
	}

	/**
	 * Caches the absli in the entity cache if it is enabled.
	 *
	 * @param absli the absli
	 */
	@Override
	public void cacheResult(Absli absli) {
		entityCache.putResult(AbsliImpl.class, absli.getPrimaryKey(), absli);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {absli.getUuid(), absli.getGroupId()}, absli);

		finderCache.putResult(
			_finderPathFetchBySourceName, new Object[] {absli.getSourceName()},
			absli);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the abslis in the entity cache if it is enabled.
	 *
	 * @param abslis the abslis
	 */
	@Override
	public void cacheResult(List<Absli> abslis) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (abslis.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Absli absli : abslis) {
			if (entityCache.getResult(AbsliImpl.class, absli.getPrimaryKey()) ==
					null) {

				cacheResult(absli);
			}
		}
	}

	/**
	 * Clears the cache for all abslis.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AbsliImpl.class);

		finderCache.clearCache(AbsliImpl.class);
	}

	/**
	 * Clears the cache for the absli.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Absli absli) {
		entityCache.removeResult(AbsliImpl.class, absli);
	}

	@Override
	public void clearCache(List<Absli> abslis) {
		for (Absli absli : abslis) {
			entityCache.removeResult(AbsliImpl.class, absli);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AbsliImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AbsliImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(AbsliModelImpl absliModelImpl) {
		Object[] args = new Object[] {
			absliModelImpl.getUuid(), absliModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, absliModelImpl);

		args = new Object[] {absliModelImpl.getSourceName()};

		finderCache.putResult(
			_finderPathCountBySourceName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySourceName, args, absliModelImpl);
	}

	/**
	 * Creates a new absli with the primary key. Does not add the absli to the database.
	 *
	 * @param id the primary key for the new absli
	 * @return the new absli
	 */
	@Override
	public Absli create(long id) {
		Absli absli = new AbsliImpl();

		absli.setNew(true);
		absli.setPrimaryKey(id);

		String uuid = _portalUUID.generate();

		absli.setUuid(uuid);

		absli.setCompanyId(CompanyThreadLocal.getCompanyId());

		return absli;
	}

	/**
	 * Removes the absli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the absli
	 * @return the absli that was removed
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	@Override
	public Absli remove(long id) throws NoSuchAbsliException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the absli with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the absli
	 * @return the absli that was removed
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	@Override
	public Absli remove(Serializable primaryKey) throws NoSuchAbsliException {
		Session session = null;

		try {
			session = openSession();

			Absli absli = (Absli)session.get(AbsliImpl.class, primaryKey);

			if (absli == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAbsliException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(absli);
		}
		catch (NoSuchAbsliException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Absli removeImpl(Absli absli) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(absli)) {
				absli = (Absli)session.get(
					AbsliImpl.class, absli.getPrimaryKeyObj());
			}

			if (absli != null) {
				session.delete(absli);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (absli != null) {
			clearCache(absli);
		}

		return absli;
	}

	@Override
	public Absli updateImpl(Absli absli) {
		boolean isNew = absli.isNew();

		if (!(absli instanceof AbsliModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(absli.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(absli);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in absli proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Absli implementation " +
					absli.getClass());
		}

		AbsliModelImpl absliModelImpl = (AbsliModelImpl)absli;

		if (Validator.isNull(absli.getUuid())) {
			String uuid = _portalUUID.generate();

			absli.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (absli.getCreateDate() == null)) {
			if (serviceContext == null) {
				absli.setCreateDate(date);
			}
			else {
				absli.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!absliModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				absli.setModifiedDate(date);
			}
			else {
				absli.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(absli);
			}
			else {
				absli = (Absli)session.merge(absli);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(AbsliImpl.class, absliModelImpl, false, true);

		cacheUniqueFindersCache(absliModelImpl);

		if (isNew) {
			absli.setNew(false);
		}

		absli.resetOriginalValues();

		return absli;
	}

	/**
	 * Returns the absli with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the absli
	 * @return the absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	@Override
	public Absli findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAbsliException {

		Absli absli = fetchByPrimaryKey(primaryKey);

		if (absli == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAbsliException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return absli;
	}

	/**
	 * Returns the absli with the primary key or throws a <code>NoSuchAbsliException</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli
	 * @throws NoSuchAbsliException if a absli with the primary key could not be found
	 */
	@Override
	public Absli findByPrimaryKey(long id) throws NoSuchAbsliException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the absli with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the absli
	 * @return the absli, or <code>null</code> if a absli with the primary key could not be found
	 */
	@Override
	public Absli fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the abslis.
	 *
	 * @return the abslis
	 */
	@Override
	public List<Absli> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Absli> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Absli> findAll(
		int start, int end, OrderByComparator<Absli> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Absli> findAll(
		int start, int end, OrderByComparator<Absli> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Absli> list = null;

		if (useFinderCache) {
			list = (List<Absli>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ABSLI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ABSLI;

				sql = sql.concat(AbsliModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Absli>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the abslis from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Absli absli : findAll()) {
			remove(absli);
		}
	}

	/**
	 * Returns the number of abslis.
	 *
	 * @return the number of abslis
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ABSLI);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ABSLI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AbsliModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the absli persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByProduct = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProduct",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"product"}, true);

		_finderPathWithoutPaginationFindByProduct = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProduct",
			new String[] {String.class.getName()}, new String[] {"product"},
			true);

		_finderPathCountByProduct = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduct",
			new String[] {String.class.getName()}, new String[] {"product"},
			false);

		_finderPathWithPaginationFindByUid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uId"}, true);

		_finderPathWithoutPaginationFindByUid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUid",
			new String[] {String.class.getName()}, new String[] {"uId"}, true);

		_finderPathCountByUid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUid",
			new String[] {String.class.getName()}, new String[] {"uId"}, false);

		_finderPathFetchBySourceName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySourceName",
			new String[] {String.class.getName()}, new String[] {"sourceName"},
			true);

		_finderPathCountBySourceName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySourceName",
			new String[] {String.class.getName()}, new String[] {"sourceName"},
			false);

		_setAbsliUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAbsliUtilPersistence(null);

		entityCache.removeCache(AbsliImpl.class.getName());
	}

	private void _setAbsliUtilPersistence(AbsliPersistence absliPersistence) {
		try {
			Field field = AbsliUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, absliPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = ABPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ABPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ABPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ABSLI =
		"SELECT absli FROM Absli absli";

	private static final String _SQL_SELECT_ABSLI_WHERE =
		"SELECT absli FROM Absli absli WHERE ";

	private static final String _SQL_COUNT_ABSLI =
		"SELECT COUNT(absli) FROM Absli absli";

	private static final String _SQL_COUNT_ABSLI_WHERE =
		"SELECT COUNT(absli) FROM Absli absli WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "absli.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Absli exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Absli exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AbsliPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private AbsliModelArgumentsResolver _absliModelArgumentsResolver;

}