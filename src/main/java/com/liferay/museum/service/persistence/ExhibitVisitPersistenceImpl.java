package com.liferay.museum.service.persistence;

import com.liferay.museum.NoSuchExhibitVisitException;
import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.model.impl.ExhibitVisitImpl;
import com.liferay.museum.model.impl.ExhibitVisitModelImpl;
import com.liferay.museum.service.persistence.ExhibitVisitPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the exhibit visit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisitPersistence
 * @see ExhibitVisitUtil
 * @generated
 */
public class ExhibitVisitPersistenceImpl extends BasePersistenceImpl<ExhibitVisit>
    implements ExhibitVisitPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ExhibitVisitUtil} to access the exhibit visit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ExhibitVisitImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, ExhibitVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, ExhibitVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GALLERYNAME =
        new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, ExhibitVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGalleryName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GALLERYNAME =
        new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, ExhibitVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGalleryName",
            new String[] { String.class.getName() },
            ExhibitVisitModelImpl.GALLERYNAME_COLUMN_BITMASK |
            ExhibitVisitModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GALLERYNAME = new FinderPath(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGalleryName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_GALLERYNAME_GALLERYNAME_1 = "exhibitVisit.galleryName IS NULL";
    private static final String _FINDER_COLUMN_GALLERYNAME_GALLERYNAME_2 = "exhibitVisit.galleryName = ?";
    private static final String _FINDER_COLUMN_GALLERYNAME_GALLERYNAME_3 = "(exhibitVisit.galleryName IS NULL OR exhibitVisit.galleryName = '')";
    private static final String _SQL_SELECT_EXHIBITVISIT = "SELECT exhibitVisit FROM ExhibitVisit exhibitVisit";
    private static final String _SQL_SELECT_EXHIBITVISIT_WHERE = "SELECT exhibitVisit FROM ExhibitVisit exhibitVisit WHERE ";
    private static final String _SQL_COUNT_EXHIBITVISIT = "SELECT COUNT(exhibitVisit) FROM ExhibitVisit exhibitVisit";
    private static final String _SQL_COUNT_EXHIBITVISIT_WHERE = "SELECT COUNT(exhibitVisit) FROM ExhibitVisit exhibitVisit WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "exhibitVisit.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExhibitVisit exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExhibitVisit exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ExhibitVisitPersistenceImpl.class);
    private static ExhibitVisit _nullExhibitVisit = new ExhibitVisitImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<ExhibitVisit> toCacheModel() {
                return _nullExhibitVisitCacheModel;
            }
        };

    private static CacheModel<ExhibitVisit> _nullExhibitVisitCacheModel = new CacheModel<ExhibitVisit>() {
            @Override
            public ExhibitVisit toEntityModel() {
                return _nullExhibitVisit;
            }
        };

    public ExhibitVisitPersistenceImpl() {
        setModelClass(ExhibitVisit.class);
    }

    /**
     * Returns all the exhibit visits where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @return the matching exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findByGalleryName(String galleryName)
        throws SystemException {
        return findByGalleryName(galleryName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the exhibit visits where galleryName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param galleryName the gallery name
     * @param start the lower bound of the range of exhibit visits
     * @param end the upper bound of the range of exhibit visits (not inclusive)
     * @return the range of matching exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findByGalleryName(String galleryName, int start,
        int end) throws SystemException {
        return findByGalleryName(galleryName, start, end, null);
    }

    /**
     * Returns an ordered range of all the exhibit visits where galleryName = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param galleryName the gallery name
     * @param start the lower bound of the range of exhibit visits
     * @param end the upper bound of the range of exhibit visits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findByGalleryName(String galleryName, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GALLERYNAME;
            finderArgs = new Object[] { galleryName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GALLERYNAME;
            finderArgs = new Object[] { galleryName, start, end, orderByComparator };
        }

        List<ExhibitVisit> list = (List<ExhibitVisit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (ExhibitVisit exhibitVisit : list) {
                if (!Validator.equals(galleryName, exhibitVisit.getGalleryName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EXHIBITVISIT_WHERE);

            boolean bindGalleryName = false;

            if (galleryName == null) {
                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_1);
            } else if (galleryName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_3);
            } else {
                bindGalleryName = true;

                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(ExhibitVisitModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindGalleryName) {
                    qPos.add(galleryName);
                }

                if (!pagination) {
                    list = (List<ExhibitVisit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ExhibitVisit>(list);
                } else {
                    list = (List<ExhibitVisit>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the first exhibit visit in the ordered set where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching exhibit visit
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a matching exhibit visit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit findByGalleryName_First(String galleryName,
        OrderByComparator orderByComparator)
        throws NoSuchExhibitVisitException, SystemException {
        ExhibitVisit exhibitVisit = fetchByGalleryName_First(galleryName,
                orderByComparator);

        if (exhibitVisit != null) {
            return exhibitVisit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("galleryName=");
        msg.append(galleryName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchExhibitVisitException(msg.toString());
    }

    /**
     * Returns the first exhibit visit in the ordered set where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching exhibit visit, or <code>null</code> if a matching exhibit visit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit fetchByGalleryName_First(String galleryName,
        OrderByComparator orderByComparator) throws SystemException {
        List<ExhibitVisit> list = findByGalleryName(galleryName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last exhibit visit in the ordered set where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching exhibit visit
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a matching exhibit visit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit findByGalleryName_Last(String galleryName,
        OrderByComparator orderByComparator)
        throws NoSuchExhibitVisitException, SystemException {
        ExhibitVisit exhibitVisit = fetchByGalleryName_Last(galleryName,
                orderByComparator);

        if (exhibitVisit != null) {
            return exhibitVisit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("galleryName=");
        msg.append(galleryName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchExhibitVisitException(msg.toString());
    }

    /**
     * Returns the last exhibit visit in the ordered set where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching exhibit visit, or <code>null</code> if a matching exhibit visit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit fetchByGalleryName_Last(String galleryName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGalleryName(galleryName);

        if (count == 0) {
            return null;
        }

        List<ExhibitVisit> list = findByGalleryName(galleryName, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the exhibit visits before and after the current exhibit visit in the ordered set where galleryName = &#63;.
     *
     * @param exhibitVisitId the primary key of the current exhibit visit
     * @param galleryName the gallery name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next exhibit visit
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit[] findByGalleryName_PrevAndNext(long exhibitVisitId,
        String galleryName, OrderByComparator orderByComparator)
        throws NoSuchExhibitVisitException, SystemException {
        ExhibitVisit exhibitVisit = findByPrimaryKey(exhibitVisitId);

        Session session = null;

        try {
            session = openSession();

            ExhibitVisit[] array = new ExhibitVisitImpl[3];

            array[0] = getByGalleryName_PrevAndNext(session, exhibitVisit,
                    galleryName, orderByComparator, true);

            array[1] = exhibitVisit;

            array[2] = getByGalleryName_PrevAndNext(session, exhibitVisit,
                    galleryName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected ExhibitVisit getByGalleryName_PrevAndNext(Session session,
        ExhibitVisit exhibitVisit, String galleryName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EXHIBITVISIT_WHERE);

        boolean bindGalleryName = false;

        if (galleryName == null) {
            query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_1);
        } else if (galleryName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_3);
        } else {
            bindGalleryName = true;

            query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(ExhibitVisitModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindGalleryName) {
            qPos.add(galleryName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(exhibitVisit);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<ExhibitVisit> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the exhibit visits where galleryName = &#63; from the database.
     *
     * @param galleryName the gallery name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGalleryName(String galleryName)
        throws SystemException {
        for (ExhibitVisit exhibitVisit : findByGalleryName(galleryName,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(exhibitVisit);
        }
    }

    /**
     * Returns the number of exhibit visits where galleryName = &#63;.
     *
     * @param galleryName the gallery name
     * @return the number of matching exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGalleryName(String galleryName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GALLERYNAME;

        Object[] finderArgs = new Object[] { galleryName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EXHIBITVISIT_WHERE);

            boolean bindGalleryName = false;

            if (galleryName == null) {
                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_1);
            } else if (galleryName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_3);
            } else {
                bindGalleryName = true;

                query.append(_FINDER_COLUMN_GALLERYNAME_GALLERYNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindGalleryName) {
                    qPos.add(galleryName);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the exhibit visit in the entity cache if it is enabled.
     *
     * @param exhibitVisit the exhibit visit
     */
    @Override
    public void cacheResult(ExhibitVisit exhibitVisit) {
        EntityCacheUtil.putResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitImpl.class, exhibitVisit.getPrimaryKey(), exhibitVisit);

        exhibitVisit.resetOriginalValues();
    }

    /**
     * Caches the exhibit visits in the entity cache if it is enabled.
     *
     * @param exhibitVisits the exhibit visits
     */
    @Override
    public void cacheResult(List<ExhibitVisit> exhibitVisits) {
        for (ExhibitVisit exhibitVisit : exhibitVisits) {
            if (EntityCacheUtil.getResult(
                        ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
                        ExhibitVisitImpl.class, exhibitVisit.getPrimaryKey()) == null) {
                cacheResult(exhibitVisit);
            } else {
                exhibitVisit.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all exhibit visits.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ExhibitVisitImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ExhibitVisitImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the exhibit visit.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(ExhibitVisit exhibitVisit) {
        EntityCacheUtil.removeResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitImpl.class, exhibitVisit.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<ExhibitVisit> exhibitVisits) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (ExhibitVisit exhibitVisit : exhibitVisits) {
            EntityCacheUtil.removeResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
                ExhibitVisitImpl.class, exhibitVisit.getPrimaryKey());
        }
    }

    /**
     * Creates a new exhibit visit with the primary key. Does not add the exhibit visit to the database.
     *
     * @param exhibitVisitId the primary key for the new exhibit visit
     * @return the new exhibit visit
     */
    @Override
    public ExhibitVisit create(long exhibitVisitId) {
        ExhibitVisit exhibitVisit = new ExhibitVisitImpl();

        exhibitVisit.setNew(true);
        exhibitVisit.setPrimaryKey(exhibitVisitId);

        return exhibitVisit;
    }

    /**
     * Removes the exhibit visit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param exhibitVisitId the primary key of the exhibit visit
     * @return the exhibit visit that was removed
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit remove(long exhibitVisitId)
        throws NoSuchExhibitVisitException, SystemException {
        return remove((Serializable) exhibitVisitId);
    }

    /**
     * Removes the exhibit visit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the exhibit visit
     * @return the exhibit visit that was removed
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit remove(Serializable primaryKey)
        throws NoSuchExhibitVisitException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ExhibitVisit exhibitVisit = (ExhibitVisit) session.get(ExhibitVisitImpl.class,
                    primaryKey);

            if (exhibitVisit == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchExhibitVisitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(exhibitVisit);
        } catch (NoSuchExhibitVisitException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected ExhibitVisit removeImpl(ExhibitVisit exhibitVisit)
        throws SystemException {
        exhibitVisit = toUnwrappedModel(exhibitVisit);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(exhibitVisit)) {
                exhibitVisit = (ExhibitVisit) session.get(ExhibitVisitImpl.class,
                        exhibitVisit.getPrimaryKeyObj());
            }

            if (exhibitVisit != null) {
                session.delete(exhibitVisit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (exhibitVisit != null) {
            clearCache(exhibitVisit);
        }

        return exhibitVisit;
    }

    @Override
    public ExhibitVisit updateImpl(
        com.liferay.museum.model.ExhibitVisit exhibitVisit)
        throws SystemException {
        exhibitVisit = toUnwrappedModel(exhibitVisit);

        boolean isNew = exhibitVisit.isNew();

        ExhibitVisitModelImpl exhibitVisitModelImpl = (ExhibitVisitModelImpl) exhibitVisit;

        Session session = null;

        try {
            session = openSession();

            if (exhibitVisit.isNew()) {
                session.save(exhibitVisit);

                exhibitVisit.setNew(false);
            } else {
                session.merge(exhibitVisit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ExhibitVisitModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((exhibitVisitModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GALLERYNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        exhibitVisitModelImpl.getOriginalGalleryName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GALLERYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GALLERYNAME,
                    args);

                args = new Object[] { exhibitVisitModelImpl.getGalleryName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GALLERYNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GALLERYNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
            ExhibitVisitImpl.class, exhibitVisit.getPrimaryKey(), exhibitVisit);

        return exhibitVisit;
    }

    protected ExhibitVisit toUnwrappedModel(ExhibitVisit exhibitVisit) {
        if (exhibitVisit instanceof ExhibitVisitImpl) {
            return exhibitVisit;
        }

        ExhibitVisitImpl exhibitVisitImpl = new ExhibitVisitImpl();

        exhibitVisitImpl.setNew(exhibitVisit.isNew());
        exhibitVisitImpl.setPrimaryKey(exhibitVisit.getPrimaryKey());

        exhibitVisitImpl.setExhibitVisitId(exhibitVisit.getExhibitVisitId());
        exhibitVisitImpl.setGroupId(exhibitVisit.getGroupId());
        exhibitVisitImpl.setCompanyId(exhibitVisit.getCompanyId());
        exhibitVisitImpl.setUserId(exhibitVisit.getUserId());
        exhibitVisitImpl.setUserName(exhibitVisit.getUserName());
        exhibitVisitImpl.setCreateDate(exhibitVisit.getCreateDate());
        exhibitVisitImpl.setModifiedDate(exhibitVisit.getModifiedDate());
        exhibitVisitImpl.setExhibitName(exhibitVisit.getExhibitName());
        exhibitVisitImpl.setVisitorId(exhibitVisit.getVisitorId());
        exhibitVisitImpl.setProximity(exhibitVisit.getProximity());
        exhibitVisitImpl.setGalleryName(exhibitVisit.getGalleryName());

        return exhibitVisitImpl;
    }

    /**
     * Returns the exhibit visit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the exhibit visit
     * @return the exhibit visit
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit findByPrimaryKey(Serializable primaryKey)
        throws NoSuchExhibitVisitException, SystemException {
        ExhibitVisit exhibitVisit = fetchByPrimaryKey(primaryKey);

        if (exhibitVisit == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchExhibitVisitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return exhibitVisit;
    }

    /**
     * Returns the exhibit visit with the primary key or throws a {@link com.liferay.museum.NoSuchExhibitVisitException} if it could not be found.
     *
     * @param exhibitVisitId the primary key of the exhibit visit
     * @return the exhibit visit
     * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit findByPrimaryKey(long exhibitVisitId)
        throws NoSuchExhibitVisitException, SystemException {
        return findByPrimaryKey((Serializable) exhibitVisitId);
    }

    /**
     * Returns the exhibit visit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the exhibit visit
     * @return the exhibit visit, or <code>null</code> if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        ExhibitVisit exhibitVisit = (ExhibitVisit) EntityCacheUtil.getResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
                ExhibitVisitImpl.class, primaryKey);

        if (exhibitVisit == _nullExhibitVisit) {
            return null;
        }

        if (exhibitVisit == null) {
            Session session = null;

            try {
                session = openSession();

                exhibitVisit = (ExhibitVisit) session.get(ExhibitVisitImpl.class,
                        primaryKey);

                if (exhibitVisit != null) {
                    cacheResult(exhibitVisit);
                } else {
                    EntityCacheUtil.putResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
                        ExhibitVisitImpl.class, primaryKey, _nullExhibitVisit);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ExhibitVisitModelImpl.ENTITY_CACHE_ENABLED,
                    ExhibitVisitImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return exhibitVisit;
    }

    /**
     * Returns the exhibit visit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param exhibitVisitId the primary key of the exhibit visit
     * @return the exhibit visit, or <code>null</code> if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit fetchByPrimaryKey(long exhibitVisitId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) exhibitVisitId);
    }

    /**
     * Returns all the exhibit visits.
     *
     * @return the exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the exhibit visits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of exhibit visits
     * @param end the upper bound of the range of exhibit visits (not inclusive)
     * @return the range of exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the exhibit visits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of exhibit visits
     * @param end the upper bound of the range of exhibit visits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<ExhibitVisit> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<ExhibitVisit> list = (List<ExhibitVisit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EXHIBITVISIT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EXHIBITVISIT;

                if (pagination) {
                    sql = sql.concat(ExhibitVisitModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<ExhibitVisit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<ExhibitVisit>(list);
                } else {
                    list = (List<ExhibitVisit>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the exhibit visits from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (ExhibitVisit exhibitVisit : findAll()) {
            remove(exhibitVisit);
        }
    }

    /**
     * Returns the number of exhibit visits.
     *
     * @return the number of exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_EXHIBITVISIT);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the exhibit visit persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.museum.model.ExhibitVisit")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ExhibitVisit>> listenersList = new ArrayList<ModelListener<ExhibitVisit>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ExhibitVisit>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ExhibitVisitImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
