package com.liferay.museum.service.persistence;

import com.liferay.museum.model.GalleryVisit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the gallery visit service. This utility wraps {@link GalleryVisitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GalleryVisitPersistence
 * @see GalleryVisitPersistenceImpl
 * @generated
 */
public class GalleryVisitUtil {
    private static GalleryVisitPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(GalleryVisit galleryVisit) {
        getPersistence().clearCache(galleryVisit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<GalleryVisit> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<GalleryVisit> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<GalleryVisit> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static GalleryVisit update(GalleryVisit galleryVisit)
        throws SystemException {
        return getPersistence().update(galleryVisit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static GalleryVisit update(GalleryVisit galleryVisit,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(galleryVisit, serviceContext);
    }

    /**
    * Caches the gallery visit in the entity cache if it is enabled.
    *
    * @param galleryVisit the gallery visit
    */
    public static void cacheResult(
        com.liferay.museum.model.GalleryVisit galleryVisit) {
        getPersistence().cacheResult(galleryVisit);
    }

    /**
    * Caches the gallery visits in the entity cache if it is enabled.
    *
    * @param galleryVisits the gallery visits
    */
    public static void cacheResult(
        java.util.List<com.liferay.museum.model.GalleryVisit> galleryVisits) {
        getPersistence().cacheResult(galleryVisits);
    }

    /**
    * Creates a new gallery visit with the primary key. Does not add the gallery visit to the database.
    *
    * @param galleryVisitId the primary key for the new gallery visit
    * @return the new gallery visit
    */
    public static com.liferay.museum.model.GalleryVisit create(
        long galleryVisitId) {
        return getPersistence().create(galleryVisitId);
    }

    /**
    * Removes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit that was removed
    * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit remove(
        long galleryVisitId)
        throws com.liferay.museum.NoSuchGalleryVisitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(galleryVisitId);
    }

    public static com.liferay.museum.model.GalleryVisit updateImpl(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(galleryVisit);
    }

    /**
    * Returns the gallery visit with the primary key or throws a {@link com.liferay.museum.NoSuchGalleryVisitException} if it could not be found.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit
    * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit findByPrimaryKey(
        long galleryVisitId)
        throws com.liferay.museum.NoSuchGalleryVisitException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(galleryVisitId);
    }

    /**
    * Returns the gallery visit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit, or <code>null</code> if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit fetchByPrimaryKey(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(galleryVisitId);
    }

    /**
    * Returns all the gallery visits.
    *
    * @return the gallery visits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.museum.model.GalleryVisit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.museum.model.GalleryVisit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.museum.model.GalleryVisit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the gallery visits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of gallery visits.
    *
    * @return the number of gallery visits
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GalleryVisitPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GalleryVisitPersistence) PortletBeanLocatorUtil.locate(com.liferay.museum.service.ClpSerializer.getServletContextName(),
                    GalleryVisitPersistence.class.getName());

            ReferenceRegistry.registerReference(GalleryVisitUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GalleryVisitPersistence persistence) {
    }
}
