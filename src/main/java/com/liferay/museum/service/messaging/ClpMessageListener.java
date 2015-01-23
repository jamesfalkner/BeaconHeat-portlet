package com.liferay.museum.service.messaging;

import com.liferay.museum.service.ClpSerializer;
import com.liferay.museum.service.ExhibitVisitLocalServiceUtil;
import com.liferay.museum.service.ExhibitVisitServiceUtil;
import com.liferay.museum.service.GalleryVisitLocalServiceUtil;
import com.liferay.museum.service.GalleryVisitServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ExhibitVisitLocalServiceUtil.clearService();

            ExhibitVisitServiceUtil.clearService();
            GalleryVisitLocalServiceUtil.clearService();

            GalleryVisitServiceUtil.clearService();
        }
    }
}
