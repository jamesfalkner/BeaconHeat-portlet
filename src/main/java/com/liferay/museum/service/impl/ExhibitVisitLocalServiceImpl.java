package com.liferay.museum.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.model.ProximityLevel;
import com.liferay.museum.service.base.ExhibitVisitLocalServiceBaseImpl;
import com.liferay.museum.service.persistence.ExhibitVisitPersistence;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the exhibit visit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.museum.service.ExhibitVisitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.museum.service.base.ExhibitVisitLocalServiceBaseImpl
 * @see com.liferay.museum.service.ExhibitVisitLocalServiceUtil
 */
public class ExhibitVisitLocalServiceImpl
    extends ExhibitVisitLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.museum.service.ExhibitVisitLocalServiceUtil} to access the exhibit visit local service.
     */
	
	public ExhibitVisit addExhibitVisit(
			long userId, long groupId, String exhibitName, String galleryName, ProximityLevel proximity, String visitorId,
			ServiceContext serviceContext)
			throws PortalException, SystemException {

			User user = userPersistence.findByPrimaryKey(userId);

			Date now = new Date();

			long evid = counterLocalService.increment(ExhibitVisit.class.getName());

			ExhibitVisit ev = exhibitVisitPersistence.create(evid);

			ev.setExhibitName(exhibitName);
			ev.setVisitorId(visitorId);
			ev.setProximity(proximity.name());
			ev.setGalleryName(galleryName);
			
			ev.setGroupId(groupId);
			ev.setCompanyId(user.getCompanyId());
			ev.setUserId(user.getUserId());
			ev.setCreateDate(serviceContext.getCreateDate(now));
			ev.setModifiedDate(serviceContext.getModifiedDate(now));

			super.addExhibitVisit(ev);

			return ev;
		}

		public ExhibitVisit deleteExhibitVisit(ExhibitVisit ev)
			throws SystemException {

			return exhibitVisitPersistence.remove(ev);
		}

		public ExhibitVisit deleteExhibitVisit(long evid)
			throws PortalException, SystemException {

			ExhibitVisit location = exhibitVisitPersistence.fetchByPrimaryKey(evid);

			return deleteExhibitVisit(location);
		}

		public ExhibitVisit updateExhibitVisit(
			long userId, long evid, String exhibitName, String galleryName, ProximityLevel proximity, String visitorId,
			ServiceContext serviceContext)
			throws PortalException, SystemException {

			Date now = new Date();

			ExhibitVisit ev = exhibitVisitPersistence.findByPrimaryKey(evid);

			ev.setExhibitName(exhibitName);
			ev.setVisitorId(visitorId);
			ev.setGalleryName(galleryName);
			ev.setProximity(proximity.name());
			ev.setModifiedDate(serviceContext.getModifiedDate(now));

			super.updateExhibitVisit(ev);

			return ev;
		}
		
		public void removeAllExhibitVisits() throws SystemException {
			exhibitVisitPersistence.removeAll();
		}

		public List<ExhibitVisit> getExhibitVisitsByGalleryName(String galleryName) throws SystemException {

		    return exhibitVisitPersistence.findByGalleryName(galleryName);
		}

		
}
