package com.liferay.museum.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for GalleryVisit. This utility wraps
 * {@link com.liferay.museum.service.impl.GalleryVisitServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see GalleryVisitService
 * @see com.liferay.museum.service.base.GalleryVisitServiceBaseImpl
 * @see com.liferay.museum.service.impl.GalleryVisitServiceImpl
 * @generated
 */
public class GalleryVisitServiceUtil {
    private static GalleryVisitService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.museum.service.impl.GalleryVisitServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static void registerVisits(java.lang.String[] galleryNames,
        java.lang.String visitorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().registerVisits(galleryNames, visitorId);
    }

    public static void clearService() {
        _service = null;
    }

    public static GalleryVisitService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GalleryVisitService.class.getName());

            if (invokableService instanceof GalleryVisitService) {
                _service = (GalleryVisitService) invokableService;
            } else {
                _service = new GalleryVisitServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(GalleryVisitServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GalleryVisitService service) {
    }
}
