package com.liferay.museum.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExhibitVisitService}.
 *
 * @author James Falkner
 * @see ExhibitVisitService
 * @generated
 */
public class ExhibitVisitServiceWrapper implements ExhibitVisitService,
    ServiceWrapper<ExhibitVisitService> {
    private ExhibitVisitService _exhibitVisitService;

    public ExhibitVisitServiceWrapper(ExhibitVisitService exhibitVisitService) {
        _exhibitVisitService = exhibitVisitService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _exhibitVisitService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _exhibitVisitService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _exhibitVisitService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void registerExhibitPings(java.lang.String encodedVisits,
        java.lang.String galleryName, java.lang.String visitorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _exhibitVisitService.registerExhibitPings(encodedVisits, galleryName,
            visitorId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ExhibitVisitService getWrappedExhibitVisitService() {
        return _exhibitVisitService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedExhibitVisitService(
        ExhibitVisitService exhibitVisitService) {
        _exhibitVisitService = exhibitVisitService;
    }

    @Override
    public ExhibitVisitService getWrappedService() {
        return _exhibitVisitService;
    }

    @Override
    public void setWrappedService(ExhibitVisitService exhibitVisitService) {
        _exhibitVisitService = exhibitVisitService;
    }
}
