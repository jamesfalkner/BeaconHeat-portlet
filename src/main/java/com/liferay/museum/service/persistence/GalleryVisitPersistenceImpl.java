package com.liferay.museum.service.persistence;

import com.liferay.museum.NoSuchGalleryVisitException;
import com.liferay.museum.model.GalleryVisit;
import com.liferay.museum.model.impl.GalleryVisitImpl;
import com.liferay.museum.model.impl.GalleryVisitModelImpl;
import com.liferay.museum.service.persistence.GalleryVisitPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the gallery visit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GalleryVisitPersistence
 * @see GalleryVisitUtil
 * @generated
 */
public class GalleryVisitPersistenceImpl extends BasePersistenceImpl<GalleryVisit>
    implements GalleryVisitPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GalleryVisitUtil} to access the gallery visit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GalleryVisitImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitModelImpl.FINDER_CACHE_ENABLED, GalleryVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitModelImpl.FINDER_CACHE_ENABLED, GalleryVisitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_GALLERYVISIT = "SELECT galleryVisit FROM GalleryVisit galleryVisit";
    private static final String _SQL_COUNT_GALLERYVISIT = "SELECT COUNT(galleryVisit) FROM GalleryVisit galleryVisit";
    private static final String _ORDER_BY_ENTITY_ALIAS = "galleryVisit.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GalleryVisit exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GalleryVisitPersistenceImpl.class);
    private static GalleryVisit _nullGalleryVisit = new GalleryVisitImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<GalleryVisit> toCacheModel() {
                return _nullGalleryVisitCacheModel;
            }
        };

    private static CacheModel<GalleryVisit> _nullGalleryVisitCacheModel = new CacheModel<GalleryVisit>() {
            @Override
            public GalleryVisit toEntityModel() {
                return _nullGalleryVisit;
            }
        };

    public GalleryVisitPersistenceImpl() {
        setModelClass(GalleryVisit.class);
    }

    /**
     * Caches the gallery visit in the entity cache if it is enabled.
     *
     * @param galleryVisit the gallery visit
     */
    @Override
    public void cacheResult(GalleryVisit galleryVisit) {
        EntityCacheUtil.putResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitImpl.class, galleryVisit.getPrimaryKey(), galleryVisit);

        galleryVisit.resetOriginalValues();
    }

    /**
     * Caches the gallery visits in the entity cache if it is enabled.
     *
     * @param galleryVisits the gallery visits
     */
    @Override
    public void cacheResult(List<GalleryVisit> galleryVisits) {
        for (GalleryVisit galleryVisit : galleryVisits) {
            if (EntityCacheUtil.getResult(
                        GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
                        GalleryVisitImpl.class, galleryVisit.getPrimaryKey()) == null) {
                cacheResult(galleryVisit);
            } else {
                galleryVisit.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all gallery visits.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GalleryVisitImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GalleryVisitImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the gallery visit.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(GalleryVisit galleryVisit) {
        EntityCacheUtil.removeResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitImpl.class, galleryVisit.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<GalleryVisit> galleryVisits) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (GalleryVisit galleryVisit : galleryVisits) {
            EntityCacheUtil.removeResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
                GalleryVisitImpl.class, galleryVisit.getPrimaryKey());
        }
    }

    /**
     * Creates a new gallery visit with the primary key. Does not add the gallery visit to the database.
     *
     * @param galleryVisitId the primary key for the new gallery visit
     * @return the new gallery visit
     */
    @Override
    public GalleryVisit create(long galleryVisitId) {
        GalleryVisit galleryVisit = new GalleryVisitImpl();

        galleryVisit.setNew(true);
        galleryVisit.setPrimaryKey(galleryVisitId);

        return galleryVisit;
    }

    /**
     * Removes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param galleryVisitId the primary key of the gallery visit
     * @return the gallery visit that was removed
     * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit remove(long galleryVisitId)
        throws NoSuchGalleryVisitException, SystemException {
        return remove((Serializable) galleryVisitId);
    }

    /**
     * Removes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the gallery visit
     * @return the gallery visit that was removed
     * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit remove(Serializable primaryKey)
        throws NoSuchGalleryVisitException, SystemException {
        Session session = null;

        try {
            session = openSession();

            GalleryVisit galleryVisit = (GalleryVisit) session.get(GalleryVisitImpl.class,
                    primaryKey);

            if (galleryVisit == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGalleryVisitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(galleryVisit);
        } catch (NoSuchGalleryVisitException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected GalleryVisit removeImpl(GalleryVisit galleryVisit)
        throws SystemException {
        galleryVisit = toUnwrappedModel(galleryVisit);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(galleryVisit)) {
                galleryVisit = (GalleryVisit) session.get(GalleryVisitImpl.class,
                        galleryVisit.getPrimaryKeyObj());
            }

            if (galleryVisit != null) {
                session.delete(galleryVisit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (galleryVisit != null) {
            clearCache(galleryVisit);
        }

        return galleryVisit;
    }

    @Override
    public GalleryVisit updateImpl(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws SystemException {
        galleryVisit = toUnwrappedModel(galleryVisit);

        boolean isNew = galleryVisit.isNew();

        Session session = null;

        try {
            session = openSession();

            if (galleryVisit.isNew()) {
                session.save(galleryVisit);

                galleryVisit.setNew(false);
            } else {
                session.merge(galleryVisit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
            GalleryVisitImpl.class, galleryVisit.getPrimaryKey(), galleryVisit);

        return galleryVisit;
    }

    protected GalleryVisit toUnwrappedModel(GalleryVisit galleryVisit) {
        if (galleryVisit instanceof GalleryVisitImpl) {
            return galleryVisit;
        }

        GalleryVisitImpl galleryVisitImpl = new GalleryVisitImpl();

        galleryVisitImpl.setNew(galleryVisit.isNew());
        galleryVisitImpl.setPrimaryKey(galleryVisit.getPrimaryKey());

        galleryVisitImpl.setGalleryVisitId(galleryVisit.getGalleryVisitId());
        galleryVisitImpl.setGalleryName(galleryVisit.getGalleryName());
        galleryVisitImpl.setVisitorId(galleryVisit.getVisitorId());
        galleryVisitImpl.setGroupId(galleryVisit.getGroupId());
        galleryVisitImpl.setCompanyId(galleryVisit.getCompanyId());
        galleryVisitImpl.setUserId(galleryVisit.getUserId());
        galleryVisitImpl.setUserName(galleryVisit.getUserName());
        galleryVisitImpl.setCreateDate(galleryVisit.getCreateDate());
        galleryVisitImpl.setModifiedDate(galleryVisit.getModifiedDate());

        return galleryVisitImpl;
    }

    /**
     * Returns the gallery visit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the gallery visit
     * @return the gallery visit
     * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGalleryVisitException, SystemException {
        GalleryVisit galleryVisit = fetchByPrimaryKey(primaryKey);

        if (galleryVisit == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGalleryVisitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return galleryVisit;
    }

    /**
     * Returns the gallery visit with the primary key or throws a {@link com.liferay.museum.NoSuchGalleryVisitException} if it could not be found.
     *
     * @param galleryVisitId the primary key of the gallery visit
     * @return the gallery visit
     * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit findByPrimaryKey(long galleryVisitId)
        throws NoSuchGalleryVisitException, SystemException {
        return findByPrimaryKey((Serializable) galleryVisitId);
    }

    /**
     * Returns the gallery visit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the gallery visit
     * @return the gallery visit, or <code>null</code> if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        GalleryVisit galleryVisit = (GalleryVisit) EntityCacheUtil.getResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
                GalleryVisitImpl.class, primaryKey);

        if (galleryVisit == _nullGalleryVisit) {
            return null;
        }

        if (galleryVisit == null) {
            Session session = null;

            try {
                session = openSession();

                galleryVisit = (GalleryVisit) session.get(GalleryVisitImpl.class,
                        primaryKey);

                if (galleryVisit != null) {
                    cacheResult(galleryVisit);
                } else {
                    EntityCacheUtil.putResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
                        GalleryVisitImpl.class, primaryKey, _nullGalleryVisit);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GalleryVisitModelImpl.ENTITY_CACHE_ENABLED,
                    GalleryVisitImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return galleryVisit;
    }

    /**
     * Returns the gallery visit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param galleryVisitId the primary key of the gallery visit
     * @return the gallery visit, or <code>null</code> if a gallery visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GalleryVisit fetchByPrimaryKey(long galleryVisitId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) galleryVisitId);
    }

    /**
     * Returns all the gallery visits.
     *
     * @return the gallery visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GalleryVisit> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the gallery visits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.GalleryVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of gallery visits
     * @param end the upper bound of the range of gallery visits (not inclusive)
     * @return the range of gallery visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GalleryVisit> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the gallery visits.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.GalleryVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of gallery visits
     * @param end the upper bound of the range of gallery visits (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of gallery visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GalleryVisit> findAll(int start, int end,
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

        List<GalleryVisit> list = (List<GalleryVisit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GALLERYVISIT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GALLERYVISIT;

                if (pagination) {
                    sql = sql.concat(GalleryVisitModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<GalleryVisit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GalleryVisit>(list);
                } else {
                    list = (List<GalleryVisit>) QueryUtil.list(q, getDialect(),
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
     * Removes all the gallery visits from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (GalleryVisit galleryVisit : findAll()) {
            remove(galleryVisit);
        }
    }

    /**
     * Returns the number of gallery visits.
     *
     * @return the number of gallery visits
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

                Query q = session.createQuery(_SQL_COUNT_GALLERYVISIT);

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
     * Initializes the gallery visit persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.museum.model.GalleryVisit")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<GalleryVisit>> listenersList = new ArrayList<ModelListener<GalleryVisit>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<GalleryVisit>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GalleryVisitImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
