<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.PrefsParamUtil" %>
<%@page import="com.liferay.museum.service.ExhibitVisitLocalServiceUtil" %>
<%@page import="com.liferay.museum.model.ExhibitVisit" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.HashSet" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@page import="com.liferay.museum.service.GalleryVisitLocalServiceUtil" %>
<%@page import="com.liferay.museum.model.GalleryVisit" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.template.TemplateHandler" %>
<%@page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<portlet:defineObjects/>

<liferay-theme:defineObjects/>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL"/>

<liferay-portlet:renderURL portletConfiguration="true" var="configurationRenderURL"/>

<liferay-portlet:renderURL portletName="166" windowState='<%= LiferayWindowState.POP_UP.toString() %>'
                           var="selectDLURL">
    <liferay-portlet:param name="struts_action" value='/dynamic_data_mapping/select_document_library'/>
    <liferay-portlet:param name="groupId" value='<%= Long.toString(scopeGroupId) %>'/>
</liferay-portlet:renderURL>

<%

    DynamicQuery q = DynamicQueryFactoryUtil.forClass(
            GalleryVisit.class, PortletClassLoaderUtil.getClassLoader());
    q.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("galleryName")));
    List<String> gallerySet = (List<String>) GalleryVisitLocalServiceUtil.dynamicQuery(q);

    String galleryName = portletPreferences.getValue("galleryName", "");

    long period = PrefsParamUtil.getLong(portletPreferences, request, "period");
    long replayLimit = PrefsParamUtil.getLong(portletPreferences, request, "replayLimit");
    boolean replayCumulative = PrefsParamUtil.getBoolean(portletPreferences, request, "replayCumulative");
    String bgImage = PrefsParamUtil.getString(portletPreferences, request, "bgImage");

    q = DynamicQueryFactoryUtil.forClass(ExhibitVisit.class, PortletClassLoaderUtil.getClassLoader());
    q.add(RestrictionsFactoryUtil.eq("galleryName", galleryName));
    q.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("exhibitName")));
    List<String> exhibitSet = (List<String>) ExhibitVisitLocalServiceUtil.dynamicQuery(q);

    int[] imageConfigIndexes = null;
    String imageConfigIndexesParam = PrefsParamUtil.getString(portletPreferences, request, "imageConfigIndexes");

    if (Validator.isNotNull(imageConfigIndexesParam)) {
        imageConfigIndexes = StringUtil.split(imageConfigIndexesParam, 0);
    } else {
        imageConfigIndexes = new int[]{0};
    }

%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">

    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL.toString() %>"/>

    <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="galleryNamePanel" persistState="<%= true %>"
                      title="Gallery">

        <c:choose>
            <c:when test="<%= gallerySet.isEmpty() %>">
                <b>No Galleries Available, Sorry!</b>
            </c:when>
            <c:otherwise>
                <aui:fieldset>
                    <aui:select inlineField="<%= true %>" name="preferences--galleryName--" label="Selected gallery">
                        <% for (String testName : gallerySet) { %>
                        <aui:option label="<%= testName %>" selected='<%= galleryName.equals(testName) %>'/>
                        <% } %>
                    </aui:select>

                    <aui:input inlineField='<%= true %>' id='bgImage' name='preferences--bgImage--' type='hidden'
                               value='<%= bgImage %>'/>

                    <img id="<portlet:namespace />bgImageImg" class="img-polaroid avatar" style="width: 70px"
                         src='<%= bgImage %>'/>

                    <aui:button inlineField="<%= true %>" onClick="selectDoc();"
                                name="selectDoc" cssClass="journal-documentlibrary-button"
                                value="Select Heatmap Image"/>


                    <aui:input inlineField="<%= true %>" name='<%= "preferences--period--" %>' value="<%= period %>"
                               label="Realtime Limit">
                        <aui:validator name="required"/>
                        <aui:validator name="digits"/>
                    </aui:input>

                    <aui:input inlineField="<%= true %>" name='<%= "preferences--replayLimit--" %>'
                               value="<%= replayLimit %>" label="Replay Limit">
                        <aui:validator name="required"/>
                        <aui:validator name="digits"/>
                    </aui:input>

                    <aui:input type="checkbox" inlineField="<%= true %>" name='<%= "preferences--replayCumulative--" %>'
                               value="<%= replayCumulative %>" label="Cumulative">
                    </aui:input>
                </aui:fieldset>
            </c:otherwise>
        </c:choose>
    </liferay-ui:panel>

    <liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id="imageConfigPanel" persistState="<%= true %>"
                      title="Exhibit Locations">

        <div id="<portlet:namespace />imageConfig">

            <aui:fieldset id="imageConfigFields">

                <%
                    for (int i = 0; i < imageConfigIndexes.length; i++) {
                        int imageConfigIndex = imageConfigIndexes[i];
                        String exhibitName = PrefsParamUtil.getString(portletPreferences, request, "exhibitName" + imageConfigIndex);
                        int xValue = PrefsParamUtil.getInteger(portletPreferences, request, "xValue" + imageConfigIndex);
                        int yValue = PrefsParamUtil.getInteger(portletPreferences, request, "yValue" + imageConfigIndex);
                %>

                    <div class="lfr-form-row lfr-form-row-inline">
                        <div class="row-fields">
                            <aui:select inlineField="<%= true %>" label="Exhibit Name"
                                        name='<%= "preferences--exhibitName" + imageConfigIndex + "--" %>'>
                                <%
                                    for (String testName : exhibitSet) { %>
                                <aui:option label="<%= testName %>" selected='<%= exhibitName.equals(testName) %>'/>
                                <% } %>
                            </aui:select>

                            <aui:input inlineField="<%= true %>"
                                       name='<%= "preferences--xValue" + imageConfigIndex + "--" %>' value="<%= xValue %>"
                                       label="X Value">
                                <aui:validator name="required"/>
                                <aui:validator name="digits"/>
                            </aui:input>

                            <aui:input inlineField="<%= true %>"
                                       name='<%= "preferences--yValue" + imageConfigIndex + "--" %>' value="<%= yValue %>"
                                       label="Y Value">
                                <aui:validator name="required"/>
                                <aui:validator name="digits"/>
                            </aui:input>
                        </div>
                    </div>

                <%
                    }
                %>

            </aui:fieldset>
        </div>

        <aui:script use="liferay-auto-fields">
            new Liferay.AutoFields(
            {
                contentBox: '#<portlet:namespace/>imageConfig > fieldset',
                fieldIndexes: '<portlet:namespace/>preferences--imageConfigIndexes--',
                namespace: '<portlet:namespace/>'
            }).render();
        </aui:script>
    </liferay-ui:panel>
    <aui:button-row>
        <aui:button type="submit" onClick="updateNames();"/>
    </aui:button-row>
</aui:form>

<aui:script>

    function _166_selectDocumentLibrary(url) {
        document.getElementById('<portlet:namespace/>bgImage').value = url;
        document.getElementById('<portlet:namespace/>bgImageImg').src = url;
    }

    function selectDoc() {

        var portletURL = Liferay.PortletURL.createRenderURL();

        portletURL.setParameter('groupId', themeDisplay.getScopeGroupId());
        portletURL.setParameter('struts_action', '/dynamic_data_mapping/select_document_library');

        portletURL.setPortletId('166');

        portletURL.setWindowState('pop_up');

        Liferay.Util.openWindow(
                {
                    id: 'selectDocumentLibrary',
                    title: Liferay.Language.get('javax.portlet.title.20'),
                    uri: portletURL.toString()
                }
        );

    }

    // replace dynamically generated AutoFields names
    function updateNames() {

        AUI().use(
                'aui-node',
                function (A) {

                    var node = document.getElementById('<portlet:namespace/>imageConfig');
                    var top = A.one('#<portlet:namespace/>imageConfig > fieldset');
                    if (!top) return;
                    top.all('*').each(function (node) {
                        var oldname = node.attr('name');
                        var newname = oldname.replace(/([0-9]+)--([0-9]+)$/, '$2--');
                        if (newname === oldname) return;
                        node.attr('name', newname);
                    });


                }
        );
    }


</aui:script>