package com.liferay.museum.service.impl;

import java.util.Date;

import com.liferay.museum.model.GalleryVisit;
import com.liferay.museum.service.base.GalleryVisitLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the gallery visit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.museum.service.GalleryVisitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.museum.service.base.GalleryVisitLocalServiceBaseImpl
 * @see com.liferay.museum.service.GalleryVisitLocalServiceUtil
 */
public class GalleryVisitLocalServiceImpl
    extends GalleryVisitLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.museum.service.GalleryVisitLocalServiceUtil} to access the gallery visit local service.
     */
	
	
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.visitorapp.service.StoreLocationLocalServiceUtil} to access the store location local service.
     */
	public GalleryVisit addGalleryVisit(
		long userId, long groupId, String galleryName, String visitorId,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long gvid = counterLocalService.increment(GalleryVisit.class.getName());

		GalleryVisit gv = galleryVisitPersistence.create(gvid);

		gv.setGalleryName(galleryName);
		gv.setVisitorId(visitorId);

		gv.setGroupId(groupId);
		gv.setCompanyId(user.getCompanyId());
		gv.setUserId(user.getUserId());
		gv.setCreateDate(serviceContext.getCreateDate(now));
		gv.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addGalleryVisit(gv);

		return gv;
	}

	public GalleryVisit deleteGalleryVisit(GalleryVisit gv)
		throws SystemException {

		return galleryVisitPersistence.remove(gv);
	}

	public GalleryVisit deleteGalleryVisit(long gvid)
		throws PortalException, SystemException {

		GalleryVisit location = galleryVisitPersistence.fetchByPrimaryKey(gvid);

		return deleteGalleryVisit(location);
	}

	public GalleryVisit updateGalleryVisit(
		long userId, long gvid, String galleryName, String visitorId,
		ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		GalleryVisit gv = galleryVisitPersistence.findByPrimaryKey(gvid);

		gv.setGalleryName(galleryName);
		gv.setVisitorId(visitorId);
		gv.setModifiedDate(serviceContext.getModifiedDate(now));

		super.updateGalleryVisit(gv);

		return gv;
	}
	
	public void removeAllGalleryVisits() throws SystemException {
		galleryVisitPersistence.removeAll();
	}

}
