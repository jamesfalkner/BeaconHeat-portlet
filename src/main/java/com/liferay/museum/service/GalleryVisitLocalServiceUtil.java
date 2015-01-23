package com.liferay.museum.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GalleryVisit. This utility wraps
 * {@link com.liferay.museum.service.impl.GalleryVisitLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author James Falkner
 * @see GalleryVisitLocalService
 * @see com.liferay.museum.service.base.GalleryVisitLocalServiceBaseImpl
 * @see com.liferay.museum.service.impl.GalleryVisitLocalServiceImpl
 * @generated
 */
public class GalleryVisitLocalServiceUtil {
    private static GalleryVisitLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.museum.service.impl.GalleryVisitLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the gallery visit to the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit addGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGalleryVisit(galleryVisit);
    }

    /**
    * Creates a new gallery visit with the primary key. Does not add the gallery visit to the database.
    *
    * @param galleryVisitId the primary key for the new gallery visit
    * @return the new gallery visit
    */
    public static com.liferay.museum.model.GalleryVisit createGalleryVisit(
        long galleryVisitId) {
        return getService().createGalleryVisit(galleryVisitId);
    }

    /**
    * Deletes the gallery visit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit that was removed
    * @throws PortalException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit deleteGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGalleryVisit(galleryVisitId);
    }

    /**
    * Deletes the gallery visit from the database. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit deleteGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGalleryVisit(galleryVisit);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.museum.model.GalleryVisit fetchGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGalleryVisit(galleryVisitId);
    }

    /**
    * Returns the gallery visit with the primary key.
    *
    * @param galleryVisitId the primary key of the gallery visit
    * @return the gallery visit
    * @throws PortalException if a gallery visit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit getGalleryVisit(
        long galleryVisitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGalleryVisit(galleryVisitId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.liferay.museum.model.GalleryVisit> getGalleryVisits(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGalleryVisits(start, end);
    }

    /**
    * Returns the number of gallery visits.
    *
    * @return the number of gallery visits
    * @throws SystemException if a system exception occurred
    */
    public static int getGalleryVisitsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGalleryVisitsCount();
    }

    /**
    * Updates the gallery visit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param galleryVisit the gallery visit
    * @return the gallery visit that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.museum.model.GalleryVisit updateGalleryVisit(
        com.liferay.museum.model.GalleryVisit galleryVisit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGalleryVisit(galleryVisit);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.museum.model.GalleryVisit addGalleryVisit(
        long userId, long groupId, java.lang.String galleryName,
        java.lang.String visitorId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addGalleryVisit(userId, groupId, galleryName, visitorId,
            serviceContext);
    }

    public static com.liferay.museum.model.GalleryVisit updateGalleryVisit(
        long userId, long gvid, java.lang.String galleryName,
        java.lang.String visitorId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateGalleryVisit(userId, gvid, galleryName, visitorId,
            serviceContext);
    }

    public static void removeAllGalleryVisits()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().removeAllGalleryVisits();
    }

    public static void clearService() {
        _service = null;
    }

    public static GalleryVisitLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GalleryVisitLocalService.class.getName());

            if (invokableLocalService instanceof GalleryVisitLocalService) {
                _service = (GalleryVisitLocalService) invokableLocalService;
            } else {
                _service = new GalleryVisitLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GalleryVisitLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GalleryVisitLocalService service) {
    }
}
