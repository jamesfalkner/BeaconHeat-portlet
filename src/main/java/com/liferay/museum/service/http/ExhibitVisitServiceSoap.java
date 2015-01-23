package com.liferay.museum.service.http;

import com.liferay.museum.service.ExhibitVisitServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.museum.service.ExhibitVisitServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.museum.model.ExhibitVisitSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.museum.model.ExhibitVisit}, that is translated to a
 * {@link com.liferay.museum.model.ExhibitVisitSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author James Falkner
 * @see ExhibitVisitServiceHttp
 * @see com.liferay.museum.model.ExhibitVisitSoap
 * @see com.liferay.museum.service.ExhibitVisitServiceUtil
 * @generated
 */
public class ExhibitVisitServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ExhibitVisitServiceSoap.class);

    public static void registerExhibitPings(java.lang.String encodedVisits,
        java.lang.String galleryName, java.lang.String visitorId)
        throws RemoteException {
        try {
            ExhibitVisitServiceUtil.registerExhibitPings(encodedVisits,
                galleryName, visitorId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
