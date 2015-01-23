package com.liferay.museum.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GalleryVisitService}.
 *
 * @author James Falkner
 * @see GalleryVisitService
 * @generated
 */
public class GalleryVisitServiceWrapper implements GalleryVisitService,
    ServiceWrapper<GalleryVisitService> {
    private GalleryVisitService _galleryVisitService;

    public GalleryVisitServiceWrapper(GalleryVisitService galleryVisitService) {
        _galleryVisitService = galleryVisitService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _galleryVisitService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _galleryVisitService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _galleryVisitService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void registerVisits(java.lang.String[] galleryNames,
        java.lang.String visitorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _galleryVisitService.registerVisits(galleryNames, visitorId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GalleryVisitService getWrappedGalleryVisitService() {
        return _galleryVisitService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGalleryVisitService(
        GalleryVisitService galleryVisitService) {
        _galleryVisitService = galleryVisitService;
    }

    @Override
    public GalleryVisitService getWrappedService() {
        return _galleryVisitService;
    }

    @Override
    public void setWrappedService(GalleryVisitService galleryVisitService) {
        _galleryVisitService = galleryVisitService;
    }
}
