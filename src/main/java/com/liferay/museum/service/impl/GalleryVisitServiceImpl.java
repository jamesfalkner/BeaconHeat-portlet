package com.liferay.museum.service.impl;

import java.util.Arrays;
import java.util.UUID;

import com.liferay.museum.model.ProximityLevel;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;
import com.liferay.museum.service.GalleryVisitLocalServiceUtil;
import com.liferay.museum.service.base.GalleryVisitServiceBaseImpl;
import com.liferay.museum.util.RandomData;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the gallery visit remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.museum.service.GalleryVisitService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.museum.service.base.GalleryVisitServiceBaseImpl
 * @see com.liferay.museum.service.GalleryVisitServiceUtil
 */
public class GalleryVisitServiceImpl extends GalleryVisitServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.museum.service.GalleryVisitServiceUtil} to access the gallery visit remote service.
     */
		
	@AccessControlled(guestAccessEnabled = true)
	public void registerVisits(String[] galleryNames, String visitorId) throws PortalException, SystemException  {

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();
		
		for (String galleryName : galleryNames) {
			GalleryVisitLocalServiceUtil.addGalleryVisit(getUserId(), guestGroupId, galleryName, visitorId, new ServiceContext());
		}
	}

	
	
	
	
	
}
