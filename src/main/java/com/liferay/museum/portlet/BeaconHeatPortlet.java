package com.liferay.museum.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.museum.model.ExhibitVisit;
import com.liferay.museum.model.ProximityLevel;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;
import com.liferay.museum.service.GalleryVisitLocalServiceUtil;
import com.liferay.museum.util.RandomData;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class BeaconHeatPortlet extends MVCPortlet {

	@Override
	public void serveResource(ResourceRequest req, ResourceResponse resp)
		throws IOException, PortletException {

		
			String cmd = req.getParameter("cmd");
			
			if (Validator.isNotNull(cmd) && cmd.equalsIgnoreCase("getExhibitVisits")) {

				String galleryName = req.getParameter("gallery");
				String from = req.getParameter("from");
				String to = req.getParameter("to");
				long now = new Date().getTime();
	            Date fromDate = (from != null) ? (new Date(now - Long.parseLong(from))) : null;
	            Date toDate = (to != null) ? (new Date(now - Long.parseLong(to))) : null;

	            // { visitors: [name1, name2, ...],
	            //   visits: [{name: "foo", proximity: "near", time: 234242}],
	            //   config: [exhibitName: "foo", x: 234, y: 32]
	            // }
				JSONObject resultObj = JSONFactoryUtil.createJSONObject();
				JSONArray resultArray = JSONFactoryUtil.createJSONArray();

				Set<String> visitors = new HashSet<String>();
				List<ExhibitVisit> visits;
				try {
					visits = ExhibitVisitLocalServiceUtil.getExhibitVisitsByGalleryName(galleryName);
				} catch (SystemException e) {
					throw new PortletException(e);
				}
				List<ExhibitVisit> finalVisits = new ArrayList<ExhibitVisit>();
				for (ExhibitVisit visit : visits) {
					User user;

					if (Validator.isNotNull(fromDate) && visit.getCreateDate().before(fromDate)) {
						continue;
					}
					
					if (Validator.isNotNull(toDate) && visit.getCreateDate().after(toDate)) {
						continue;
					}

					finalVisits.add(visit);

					try {
						user = UserLocalServiceUtil.getUser(visit.getUserId());
					} catch (PortalException e) {
						throw new PortletException(e);
					} catch (SystemException e) {
						throw new PortletException(e);
					}
					
					if (user.isDefaultUser()) {
						visitors.add("Anonymous Coward");
					} else {
						visitors.add(user.getFullName());
					}
				}
				
				JSONArray visitorsArray = JSONFactoryUtil.createJSONArray();
				for (String visitor : visitors) {
					visitorsArray.put(visitor);
				}
				
				resultObj.put("visitors", visitorsArray);

				for (ExhibitVisit visit : finalVisits) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("name", visit.getExhibitName());
					obj.put("proximity", visit.getProximity());
					obj.put("time", visit.getCreateDate().getTime());
					resultArray.put(obj);
				}
			
				resultObj.put("visits", resultArray);
				
				String indexesStr = req.getPreferences().getValue("imageConfigIndexes", "0");
				int[] indexes = StringUtil.split(indexesStr, 0);
				
				resultArray = JSONFactoryUtil.createJSONArray();

				for (int idx : indexes) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					String exhibitName = req.getPreferences().getValue("exhibitName" + idx, null);
					int xVal = GetterUtil.getInteger(req.getPreferences().getValue("xValue" + idx, null));
					int yVal = GetterUtil.getInteger(req.getPreferences().getValue("yValue" + idx, null));
					obj.put("exhibitName", exhibitName);
					obj.put("x", xVal);
					obj.put("y",  yVal);
					resultArray.put(obj);
				}
				
				resultObj.put("config",  resultArray);

				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write(resultObj.toString());
			}
		}
	
	@ProcessAction(name="clearAll")
	public void clearAll(ActionRequest request, ActionResponse response)
	        throws PortletException, IOException, SystemException {
		
		GalleryVisitLocalServiceUtil.removeAllGalleryVisits();
		ExhibitVisitLocalServiceUtil.removeAllExhibitVisits();
	}

	@ProcessAction(name="randomData")
	public void randomData(ActionRequest request, ActionResponse response)
	        throws SystemException, PortalException, ReadOnlyException, ValidatorException, IOException {
		
		int amt = GetterUtil.getInteger(request.getParameter("amount"));
		boolean setPrefs = GetterUtil.getBoolean(request.getParameter("setPrefs"));
		if (amt <= 0) {
			return;
		}
		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		for (int i = 0; i < amt; i++) {
			String galleryName = RandomData.GALLERY_NAMES[(int)(Math.floor(Math.random() * RandomData.GALLERY_NAMES.length))];
			String exhibitName = RandomData.EXHIBIT_NAMES[(int)(Math.floor(Math.random() * RandomData.EXHIBIT_NAMES.length))];
			ProximityLevel proximity = ProximityLevel.values()[(int)(Math.floor(Math.random() * ProximityLevel.values().length))];
			String visitorId = UUID.randomUUID().toString();

			if (Math.random() < .5) {
				GalleryVisitLocalServiceUtil.addGalleryVisit(PortalUtil.getUserId(request), guestGroupId, galleryName, visitorId, new ServiceContext());
			}
			ExhibitVisit newVisit = ExhibitVisitLocalServiceUtil.addExhibitVisit(PortalUtil.getUserId(request), guestGroupId, exhibitName, galleryName, proximity, visitorId, new ServiceContext());
			Date randTime = new Date((long)(new Date().getTime() - (Math.random() * 10*60*1000)));
			newVisit.setCreateDate(randTime);
			ExhibitVisitLocalServiceUtil.updateExhibitVisit(newVisit);
		}

		
		if (setPrefs) {
			// fake the preferences to show a good heatmap
			PortletPreferences prefs = request.getPreferences();
			String galleryName = RandomData.GALLERY_NAMES[(int)(Math.floor(Math.random() * RandomData.GALLERY_NAMES.length))];
	
			prefs.setValue("galleryName", galleryName);
			
			int[] imageConfigIndexes = new int[RandomData.EXHIBIT_NAMES.length];
			
			for (int i = 0; i < RandomData.EXHIBIT_NAMES.length; i++) {
				imageConfigIndexes[i] = i;
				prefs.setValue("exhibitName" + i, "" + RandomData.EXHIBIT_NAMES[i]);
				prefs.setValue("xValue" + i, "" + (int)Math.floor(Math.random() * 1000));
				prefs.setValue("yValue" + i, "" + (int)Math.floor(Math.random() * 1000));
			}
			prefs.setValue("imageConfigIndexes", StringUtil.merge(imageConfigIndexes));
			
			prefs.store();
		}
		
	}


}
