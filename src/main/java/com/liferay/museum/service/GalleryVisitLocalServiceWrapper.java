package com.liferay.museum.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GalleryVisitLocalService}.
 *
 * @author James Falkner
 * @see GalleryVisitLocalService
 * @generated
 */
public class GalleryVisitLocalServiceWrapper implements GalleryVisitLocalService,
    ServiceWrapper<GalleryVisitLocalService> {
    private GalleryVisitLocalService _galleryVisitLocalService;

    public GalleryVisitLocalServiceWrapper(
        GalleryVisitLocalService galleryVisitLocalService) {
        _galleryVisitLocalService = galleryVisitLocalService;
    }

    /**
    * Adds the gallery visit to the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.museum.model.GalleryVisit addGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.addGalleryVisit(galleryVisit);
    }

    /**
    * Creates a new gallery visit with the primary key. Does not add the gallery visit to the database.
    *
    * @param galleryVisitId the primary key for the new gallery visit
    * @return the new gallery visit
    */
    @Override
    public com.liferay.museum.model.GalleryVisit createGalleryVisit(
        long galleryVisitId) {
        return _galleryVisitLocalService.createGalleryVisit(galleryVisitId);
    }

    /**
    * Deletes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit that was removed
    * @throws PortalException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.museum.model.GalleryVisit deleteGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.deleteGalleryVisit(galleryVisitId);
    }

    /**
    * Deletes the gallery visit from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.museum.model.GalleryVisit deleteGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.deleteGalleryVisit(galleryVisit);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _galleryVisitLocalService.dynamicQuery();
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.GalleryVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.museum.model.impl.GalleryVisitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.dynamicQueryCount(dynamicQuery);
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
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.museum.model.GalleryVisit fetchGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.fetchGalleryVisit(galleryVisitId);
    }

    /**
    * Returns the gallery visit with the primary key.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit
    * @throws PortalException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.museum.model.GalleryVisit getGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.getGalleryVisit(galleryVisitId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.liferay.museum.model.GalleryVisit> getGalleryVisits(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.getGalleryVisits(start, end);
    }

    /**
    * Returns the number of gallery visits.
    *
    * @return the number of gallery visits
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getGalleryVisitsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.getGalleryVisitsCount();
    }

    /**
    * Updates the gallery visit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.museum.model.GalleryVisit updateGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.updateGalleryVisit(galleryVisit);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _galleryVisitLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _galleryVisitLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _galleryVisitLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.museum.model.GalleryVisit addGalleryVisit(long userId,
        long groupId, java.lang.String galleryName, java.lang.String visitorId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.addGalleryVisit(userId, groupId,
            galleryName, visitorId, serviceContext);
    }

    @Override
    public com.liferay.museum.model.GalleryVisit updateGalleryVisit(
        long userId, long gvid, java.lang.String galleryName,
        java.lang.String visitorId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _galleryVisitLocalService.updateGalleryVisit(userId, gvid,
            galleryName, visitorId, serviceContext);
    }

    @Override
    public void removeAllGalleryVisits()
        throws com.liferay.portal.kernel.exception.SystemException {
        _galleryVisitLocalService.removeAllGalleryVisits();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GalleryVisitLocalService getWrappedGalleryVisitLocalService() {
        return _galleryVisitLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGalleryVisitLocalService(
        GalleryVisitLocalService galleryVisitLocalService) {
        _galleryVisitLocalService = galleryVisitLocalService;
    }

    @Override
    public GalleryVisitLocalService getWrappedService() {
        return _galleryVisitLocalService;
    }

    @Override
    public void setWrappedService(
        GalleryVisitLocalService galleryVisitLocalService) {
        _galleryVisitLocalService = galleryVisitLocalService;
    }
}
