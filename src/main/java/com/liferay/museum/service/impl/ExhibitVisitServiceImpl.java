package com.liferay.museum.service.impl;

import com.liferay.museum.model.ProximityLevel;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;
import com.liferay.museum.service.base.ExhibitVisitServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the exhibit visit remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.museum.service.ExhibitVisitService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.museum.service.base.ExhibitVisitServiceBaseImpl
 * @see com.liferay.museum.service.ExhibitVisitServiceUtil
 */
public class ExhibitVisitServiceImpl extends ExhibitVisitServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.museum.service.ExhibitVisitServiceUtil} to access the exhibit visit remote service.
     */
	
	@AccessControlled(guestAccessEnabled = true)
	public void registerExhibitPings(String encodedVisits, String galleryName, String visitorId) throws PortalException, SystemException {

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		JSONArray visitArray = JSONFactoryUtil.createJSONArray(encodedVisits);
		int len = visitArray.length();
		
		for (int i = 0; i < len; i++) {
			JSONObject visit = visitArray.getJSONObject(i);
			String exhibitName = visit.getString("name");
			ProximityLevel prox = ProximityLevel.proximityFromString(visit.getString("proximity"));
			ExhibitVisitLocalServiceUtil.addExhibitVisit(getUserId(), guestGroupId, exhibitName, galleryName, prox, visitorId, new ServiceContext());
		}
	}

}
