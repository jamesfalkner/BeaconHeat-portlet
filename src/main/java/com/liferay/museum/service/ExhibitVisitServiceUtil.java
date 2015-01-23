package com.liferay.museum.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ExhibitVisit. This utility wraps
 * {@link com.liferay.museum.service.impl.ExhibitVisitServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see ExhibitVisitService
 * @see com.liferay.museum.service.base.ExhibitVisitServiceBaseImpl
 * @see com.liferay.museum.service.impl.ExhibitVisitServiceImpl
 * @generated
 */
public class ExhibitVisitServiceUtil {
    private static ExhibitVisitService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.museum.service.impl.ExhibitVisitServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static void registerExhibitPings(java.lang.String encodedVisits,
        java.lang.String galleryName, java.lang.String visitorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().registerExhibitPings(encodedVisits, galleryName, visitorId);
    }

    public static void clearService() {
        _service = null;
    }

    public static ExhibitVisitService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ExhibitVisitService.class.getName());

            if (invokableService instanceof ExhibitVisitService) {
                _service = (ExhibitVisitService) invokableService;
            } else {
                _service = new ExhibitVisitServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(ExhibitVisitServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ExhibitVisitService service) {
    }
}
