package com.liferay.museum.service.persistence;

import com.liferay.museum.model.GalleryVisit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the gallery visit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GalleryVisitPersistenceImpl
 * @see GalleryVisitUtil
 * @generated
 */
public interface GalleryVisitPersistence extends BasePersistence<GalleryVisit> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GalleryVisitUtil} to access the gallery visit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the gallery visit in the entity cache if it is enabled.
    *
    * @param galleryVisit the gallery visit
    */
    public void cacheResult(com.liferay.museum.model.GalleryVisit galleryVisit);

    /**
    * Caches the gallery visits in the entity cache if it is enabled.
    *
    * @param galleryVisits the gallery visits
    */
    public void cacheResult(
        java.util.List<com.liferay.museum.model.GalleryVisit> galleryVisits);

    /**
    * Creates a new gallery visit with the primary key. Does not add the gallery visit to the database.
    *
    * @param galleryVisitId the primary key for the new gallery visit
    * @return the new gallery visit
    */
    public com.liferay.museum.model.GalleryVisit create(long galleryVisitId);

    /**
    * Removes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit that was removed
    * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.GalleryVisit remove(long galleryVisitId)
        throws com.liferay.museum.NoSuchGalleryVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.museum.model.GalleryVisit updateImpl(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the gallery visit with the primary key or throws a {@link com.liferay.museum.NoSuchGalleryVisitException} if it could not be found.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit
    * @throws com.liferay.museum.NoSuchGalleryVisitException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.GalleryVisit findByPrimaryKey(
        long galleryVisitId)
        throws com.liferay.museum.NoSuchGalleryVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the gallery visit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit, or <code>null</code> if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.GalleryVisit fetchByPrimaryKey(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the gallery visits.
    *
    * @return the gallery visits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.museum.model.GalleryVisit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.GalleryVisit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.GalleryVisit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the gallery visits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of gallery visits.
    *
    * @return the number of gallery visits
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
