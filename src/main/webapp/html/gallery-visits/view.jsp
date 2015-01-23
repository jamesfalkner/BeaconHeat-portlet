<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Visitor"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.museum.service.GalleryVisitLocalServiceUtil" %>
<%@page import="com.liferay.museum.model.GalleryVisit" %>
<%@page import="java.util.List" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="com.liferay.portlet.portletdisplaytemplate.util.PortletDisplayTemplateUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects />

<%!
    com.liferay.portal.kernel.dao.search.SearchContainer<GalleryVisit> searchContainer = null;
%>

<h1>Gallery Visits</h1>
<liferay-ui:search-container emptyResultsMessage="There are no visits to display">
    <liferay-ui:search-container-results
            results="<%= GalleryVisitLocalServiceUtil.getGalleryVisits(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= GalleryVisitLocalServiceUtil.getGalleryVisitsCount() %>"
            />

    <liferay-ui:search-container-row
            className="com.liferay.museum.model.GalleryVisit"
            keyProperty="galleryVisitId"
            modelVar="visit" escapedModel="<%= true %>"
            >

        <liferay-ui:search-container-column-text
                name="Gallery"
                value="<%= visit.getGalleryName() %>"
                href='<%= "http://maps.google.com/?q=" + HtmlUtil.escapeURL(visit.getGalleryName()) %>'
                />

        <liferay-ui:search-container-column-text
                name="Visitor ID"
                value="<%= visit.getVisitorId() %>"
                />
                
        <liferay-ui:search-container-column-text
                name="Name"
                href='<%= UserLocalServiceUtil.getUser(visit.getUserId()).getDisplayURL(themeDisplay) %>'
                value="<%= HtmlUtil.escape(UserLocalServiceUtil.getUser(visit.getUserId()).getFullName()) %>"
                />
                
        <liferay-ui:search-container-column-date
                name="When"
                value="<%= visit.getCreateDate() %>"
                />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

