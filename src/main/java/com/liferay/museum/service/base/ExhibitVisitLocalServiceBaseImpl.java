package com.liferay.museum.service.base;

import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.service.ExhibitVisitLocalService;
import com.liferay.museum.service.persistence.ExhibitVisitPersistence;
import com.liferay.museum.service.persistence.GalleryVisitPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the exhibit visit local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.museum.service.impl.ExhibitVisitLocalServiceImpl}.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.museum.service.impl.ExhibitVisitLocalServiceImpl
 * @see com.liferay.museum.service.ExhibitVisitLocalServiceUtil
 * @generated
 */
public abstract class ExhibitVisitLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements ExhibitVisitLocalService,
        IdentifiableBean {
    @BeanReference(type = com.liferay.museum.service.ExhibitVisitLocalService.class)
    protected com.liferay.museum.service.ExhibitVisitLocalService exhibitVisitLocalService;
    @BeanReference(type = com.liferay.museum.service.ExhibitVisitService.class)
    protected com.liferay.museum.service.ExhibitVisitService exhibitVisitService;
    @BeanReference(type = ExhibitVisitPersistence.class)
    protected ExhibitVisitPersistence exhibitVisitPersistence;
    @BeanReference(type = com.liferay.museum.service.GalleryVisitLocalService.class)
    protected com.liferay.museum.service.GalleryVisitLocalService galleryVisitLocalService;
    @BeanReference(type = com.liferay.museum.service.GalleryVisitService.class)
    protected com.liferay.museum.service.GalleryVisitService galleryVisitService;
    @BeanReference(type = GalleryVisitPersistence.class)
    protected GalleryVisitPersistence galleryVisitPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ExhibitVisitLocalServiceClpInvoker _clpInvoker = new ExhibitVisitLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.museum.service.ExhibitVisitLocalServiceUtil} to access the exhibit visit local service.
     */

    /**
     * Adds the exhibit visit to the database. Also notifies the appropriate model listeners.
     *
     * @param exhibitVisit the exhibit visit
     * @return the exhibit visit that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ExhibitVisit addExhibitVisit(ExhibitVisit exhibitVisit)
        throws SystemException {
        exhibitVisit.setNew(true);

        return exhibitVisitPersistence.update(exhibitVisit);
    }

    /**
     * Creates a new exhibit visit with the primary key. Does not add the exhibit visit to the database.
     *
     * @param exhibitVisitId the primary key for the new exhibit visit
     * @return the new exhibit visit
     */
    @Override
    public ExhibitVisit createExhibitVisit(long exhibitVisitId) {
        return exhibitVisitPersistence.create(exhibitVisitId);
    }

    /**
     * Deletes the exhibit visit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param exhibitVisitId the primary key of the exhibit visit
     * @return the exhibit visit that was removed
     * @throws PortalException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ExhibitVisit deleteExhibitVisit(long exhibitVisitId)
        throws PortalException, SystemException {
        return exhibitVisitPersistence.remove(exhibitVisitId);
    }

    /**
     * Deletes the exhibit visit from the database. Also notifies the appropriate model listeners.
     *
     * @param exhibitVisit the exhibit visit
     * @return the exhibit visit that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public ExhibitVisit deleteExhibitVisit(ExhibitVisit exhibitVisit)
        throws SystemException {
        return exhibitVisitPersistence.remove(exhibitVisit);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(ExhibitVisit.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return exhibitVisitPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return exhibitVisitPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.ExhibitVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return exhibitVisitPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return exhibitVisitPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return exhibitVisitPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public ExhibitVisit fetchExhibitVisit(long exhibitVisitId)
        throws SystemException {
        return exhibitVisitPersistence.fetchByPrimaryKey(exhibitVisitId);
    }

    /**
     * Returns the exhibit visit with the primary key.
     *
     * @param exhibitVisitId the primary key of the exhibit visit
     * @return the exhibit visit
     * @throws PortalException if a exhibit visit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public ExhibitVisit getExhibitVisit(long exhibitVisitId)
        throws PortalException, SystemException {
        return exhibitVisitPersistence.findByPrimaryKey(exhibitVisitId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return exhibitVisitPersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<ExhibitVisit> getExhibitVisits(int start, int end)
        throws SystemException {
        return exhibitVisitPersistence.findAll(start, end);
    }

    /**
     * Returns the number of exhibit visits.
     *
     * @return the number of exhibit visits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getExhibitVisitsCount() throws SystemException {
        return exhibitVisitPersistence.countAll();
    }

    /**
     * Updates the exhibit visit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param exhibitVisit the exhibit visit
     * @return the exhibit visit that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public ExhibitVisit updateExhibitVisit(ExhibitVisit exhibitVisit)
        throws SystemException {
        return exhibitVisitPersistence.update(exhibitVisit);
    }

    /**
     * Returns the exhibit visit local service.
     *
     * @return the exhibit visit local service
     */
    public com.liferay.museum.service.ExhibitVisitLocalService getExhibitVisitLocalService() {
        return exhibitVisitLocalService;
    }

    /**
     * Sets the exhibit visit local service.
     *
     * @param exhibitVisitLocalService the exhibit visit local service
     */
    public void setExhibitVisitLocalService(
        com.liferay.museum.service.ExhibitVisitLocalService exhibitVisitLocalService) {
        this.exhibitVisitLocalService = exhibitVisitLocalService;
    }

    /**
     * Returns the exhibit visit remote service.
     *
     * @return the exhibit visit remote service
     */
    public com.liferay.museum.service.ExhibitVisitService getExhibitVisitService() {
        return exhibitVisitService;
    }

    /**
     * Sets the exhibit visit remote service.
     *
     * @param exhibitVisitService the exhibit visit remote service
     */
    public void setExhibitVisitService(
        com.liferay.museum.service.ExhibitVisitService exhibitVisitService) {
        this.exhibitVisitService = exhibitVisitService;
    }

    /**
     * Returns the exhibit visit persistence.
     *
     * @return the exhibit visit persistence
     */
    public ExhibitVisitPersistence getExhibitVisitPersistence() {
        return exhibitVisitPersistence;
    }

    /**
     * Sets the exhibit visit persistence.
     *
     * @param exhibitVisitPersistence the exhibit visit persistence
     */
    public void setExhibitVisitPersistence(
        ExhibitVisitPersistence exhibitVisitPersistence) {
        this.exhibitVisitPersistence = exhibitVisitPersistence;
    }

    /**
     * Returns the gallery visit local service.
     *
     * @return the gallery visit local service
     */
    public com.liferay.museum.service.GalleryVisitLocalService getGalleryVisitLocalService() {
        return galleryVisitLocalService;
    }

    /**
     * Sets the gallery visit local service.
     *
     * @param galleryVisitLocalService the gallery visit local service
     */
    public void setGalleryVisitLocalService(
        com.liferay.museum.service.GalleryVisitLocalService galleryVisitLocalService) {
        this.galleryVisitLocalService = galleryVisitLocalService;
    }

    /**
     * Returns the gallery visit remote service.
     *
     * @return the gallery visit remote service
     */
    public com.liferay.museum.service.GalleryVisitService getGalleryVisitService() {
        return galleryVisitService;
    }

    /**
     * Sets the gallery visit remote service.
     *
     * @param galleryVisitService the gallery visit remote service
     */
    public void setGalleryVisitService(
        com.liferay.museum.service.GalleryVisitService galleryVisitService) {
        this.galleryVisitService = galleryVisitService;
    }

    /**
     * Returns the gallery visit persistence.
     *
     * @return the gallery visit persistence
     */
    public GalleryVisitPersistence getGalleryVisitPersistence() {
        return galleryVisitPersistence;
    }

    /**
     * Sets the gallery visit persistence.
     *
     * @param galleryVisitPersistence the gallery visit persistence
     */
    public void setGalleryVisitPersistence(
        GalleryVisitPersistence galleryVisitPersistence) {
        this.galleryVisitPersistence = galleryVisitPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("com.liferay.museum.model.ExhibitVisit",
            exhibitVisitLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.liferay.museum.model.ExhibitVisit");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return ExhibitVisit.class;
    }

    protected String getModelClassName() {
        return ExhibitVisit.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = exhibitVisitPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
