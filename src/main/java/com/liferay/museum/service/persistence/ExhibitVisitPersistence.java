package com.liferay.museum.service.persistence;

import com.liferay.museum.model.ExhibitVisit;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the exhibit visit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisitPersistenceImpl
 * @see ExhibitVisitUtil
 * @generated
 */
public interface ExhibitVisitPersistence extends BasePersistence<ExhibitVisit> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ExhibitVisitUtil} to access the exhibit visit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the exhibit visits where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @return the matching exhibit visits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findByGalleryName(
        java.lang.String galleryName)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findByGalleryName(
        java.lang.String galleryName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findByGalleryName(
        java.lang.String galleryName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first exhibit visit in the ordered set where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching exhibit visit
    * @throws com.liferay.museum.NoSuchExhibitVisitException if a matching exhibit visit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit findByGalleryName_First(
        java.lang.String galleryName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.museum.NoSuchExhibitVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first exhibit visit in the ordered set where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching exhibit visit, or <code>null</code> if a matching exhibit visit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit fetchByGalleryName_First(
        java.lang.String galleryName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last exhibit visit in the ordered set where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching exhibit visit
    * @throws com.liferay.museum.NoSuchExhibitVisitException if a matching exhibit visit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit findByGalleryName_Last(
        java.lang.String galleryName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.museum.NoSuchExhibitVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last exhibit visit in the ordered set where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching exhibit visit, or <code>null</code> if a matching exhibit visit could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit fetchByGalleryName_Last(
        java.lang.String galleryName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.museum.model.ExhibitVisit[] findByGalleryName_PrevAndNext(
        long exhibitVisitId, java.lang.String galleryName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.museum.NoSuchExhibitVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the exhibit visits where galleryName = &#63; from the database.
    *
    * @param galleryName the gallery name
    * @throws SystemException if a system exception occurred
    */
    public void removeByGalleryName(java.lang.String galleryName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of exhibit visits where galleryName = &#63;.
    *
    * @param galleryName the gallery name
    * @return the number of matching exhibit visits
    * @throws SystemException if a system exception occurred
    */
    public int countByGalleryName(java.lang.String galleryName)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the exhibit visit in the entity cache if it is enabled.
    *
    * @param exhibitVisit the exhibit visit
    */
    public void cacheResult(com.liferay.museum.model.ExhibitVisit exhibitVisit);

    /**
    * Caches the exhibit visits in the entity cache if it is enabled.
    *
    * @param exhibitVisits the exhibit visits
    */
    public void cacheResult(
        java.util.List<com.liferay.museum.model.ExhibitVisit> exhibitVisits);

    /**
    * Creates a new exhibit visit with the primary key. Does not add the exhibit visit to the database.
    *
    * @param exhibitVisitId the primary key for the new exhibit visit
    * @return the new exhibit visit
    */
    public com.liferay.museum.model.ExhibitVisit create(long exhibitVisitId);

    /**
    * Removes the exhibit visit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param exhibitVisitId the primary key of the exhibit visit
    * @return the exhibit visit that was removed
    * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit remove(long exhibitVisitId)
        throws com.liferay.museum.NoSuchExhibitVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.museum.model.ExhibitVisit updateImpl(
        com.liferay.museum.model.ExhibitVisit exhibitVisit)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the exhibit visit with the primary key or throws a {@link com.liferay.museum.NoSuchExhibitVisitException} if it could not be found.
    *
    * @param exhibitVisitId the primary key of the exhibit visit
    * @return the exhibit visit
    * @throws com.liferay.museum.NoSuchExhibitVisitException if a exhibit visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit findByPrimaryKey(
        long exhibitVisitId)
        throws com.liferay.museum.NoSuchExhibitVisitException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the exhibit visit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param exhibitVisitId the primary key of the exhibit visit
    * @return the exhibit visit, or <code>null</code> if a exhibit visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.museum.model.ExhibitVisit fetchByPrimaryKey(
        long exhibitVisitId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the exhibit visits.
    *
    * @return the exhibit visits
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.museum.model.ExhibitVisit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the exhibit visits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of exhibit visits.
    *
    * @return the number of exhibit visits
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
