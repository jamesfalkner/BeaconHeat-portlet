<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="java.util.Date" %>
<%@page import="com.liferay.museum.model.ProximityLevel" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%@ page import="com.liferay.portal.util.PortalUtil" %>

<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    String selectedGallery = portletPreferences.getValue("galleryName", "Amsterdam");
    String bgImageUrl = portletPreferences.getValue("bgImage", "");
    long selectedTime = Long.parseLong(portletPreferences.getValue("period", "60"));
    long replayLimit = Long.parseLong(portletPreferences.getValue("replayLimit", "300"));
    boolean replayCumulative = GetterUtil.getBoolean(portletPreferences.getValue("replayCumulative", "true"));

%>

<style type="text/css">
    #<portlet:namespace />visitorList {
        position: absolute;
        overflow: hidden;
        top: 60px;
        right: 0px;
        font-weight: bold;
        font-size: 1.2em;
        background-color: rgba(100, 100, 100, 0.5);
        padding: 10px;
    }

    #<portlet:namespace />visitorList span {
    	color: white;
	}
	
    #<portlet:namespace />heatmapContainerWrapper {
        width: 1024px;
        height: 768px;
    }

    #<portlet:namespace />heatmapContainer {
        width: 100%;
        height: 100%;
    }

    #<portlet:namespace />replayMarker {
        float: right;
        font-family: "Courier New", Courier, monospace
    }

    .slider {
        display: inline-block;
        zoom: 1;
        *display: inline;
        vertical-align: bottom;
        overflow: hidden;
    }

</style>

<portlet:actionURL name="clearAll" var="clearAllURL"/>
<portlet:actionURL name="randomData" var="randomDataURL"/>

<button type="button" onclick="<portlet:namespace/>staticHeatmap();">Static</button>
<button type="button" onclick="<portlet:namespace/>realtimeHeatmap();">Real-time</button>
<button type="button" onclick="<portlet:namespace/>replayHeatmap();">Replay</button>
<span id="<portlet:namespace />replayMarker"></span>

<!-- slider boundingBox -->

<span class="control-label">Intensity</span>

<span id="<portlet:namespace />maxSlider" class="slider yui3-skin-sam yui3-widget yui3-sliderbase yui-slider">
    <!-- contentBox -->
    <span class="yui3-slider-content yui3-slider-x"><!-- or slider-y -->

        <!-- rail -->
        <span class="yui3-slider-rail">
            <span class="yui3-slider-rail-cap-left"></span><!-- or cap-top -->
            <span class="yui3-slider-rail-cap-right"></span><!-- or cap-bottom -->

            <!-- thumb -->
            <span class="yui3-slider-thumb">
                <img class="yui3-slider-thumb-shadow">
                <img class="yui3-slider-thumb-image">
            </span>
        </span>

    </span>
</span>

<span class="control-label">Jitter</span>

<span id="<portlet:namespace />jitterSlider" class="slider yui3-skin-sam yui3-widget yui3-sliderbase yui-slider">
    <!-- contentBox -->
    <span class="yui3-slider-content yui3-slider-x"><!-- or slider-y -->

        <!-- rail -->
        <span class="yui3-slider-rail">
            <span class="yui3-slider-rail-cap-left"></span><!-- or cap-top -->
            <span class="yui3-slider-rail-cap-right"></span><!-- or cap-bottom -->

            <!-- thumb -->
            <span class="yui3-slider-thumb">
                <img class="yui3-slider-thumb-shadow">
                <img class="yui3-slider-thumb-image">
            </span>
        </span>

    </span>
</span>

<br>
<br>

<div style="background-image: url('<%= bgImageUrl %>'); background-size:cover;"
     id="<portlet:namespace />heatmapContainerWrapper">
    <div id="<portlet:namespace />heatmapContainer">
    </div>
    
    <div id="<portlet:namespace />visitorList">
    </div>
</div>

<br>

<aui:form action='<%= clearAllURL %>' method="post">
    <aui:fieldset>
        <aui:button type="submit" value="Clear All Visits"/>
    </aui:fieldset>
</aui:form>

<br>

<aui:form action='<%=randomDataURL %>' method="post">
    <aui:fieldset>
        <aui:input inlineField="<%= true %>" label="Number of Visits" name='amount' value="1000"/>
        <aui:input inlineField="<%= true %>" label="Set Preferences" type="checkbox" name='setPrefs'
                   value='<%= false %>'/>
        <aui:button inlineField="<%= true %>" type="submit" value="Generate Random Visits"/>
    </aui:fieldset>
</aui:form>

<portlet:resourceURL var="getAllExhibitsURL">
    <portlet:param name="cmd" value="getExhibitVisits"/>
    <portlet:param name="gallery" value="<%= selectedGallery %>"/>
</portlet:resourceURL>

<portlet:resourceURL var="getExhibitsURL">
    <portlet:param name="cmd" value="getExhibitVisits"/>
    <portlet:param name="gallery" value="<%= selectedGallery %>"/>
    <portlet:param name="from" value='<%=Long.toString(selectedTime * 1000) %>'/>
    <portlet:param name="to" value='0'/>
</portlet:resourceURL>

<portlet:resourceURL var="getReplayExhibitsURL">
    <portlet:param name="cmd" value="getExhibitVisits"/>
    <portlet:param name="gallery" value="<%= selectedGallery %>"/>
    <portlet:param name="from" value='<%=Long.toString(replayLimit * 1000) %>'/>
    <portlet:param name="to" value='0'/>
</portlet:resourceURL>

<script type="text/javascript">

    var <portlet:namespace />realtimeInterval = null;
    var <portlet:namespace />replayTimer = null;
    var <portlet:namespace />heatMap = null;
    var <portlet:namespace />maxValue = 100;
    var <portlet:namespace />jitter = 3;

    <%
    if (replayCumulative) {
    %>
    var <portlet:namespace />replayCumulativeFlag = true;
    <%
    } else {
    %>
    var <portlet:namespace />replayCumulativeFlag = false;
    <%
    }
    %>

    window.onload = function () {

        YUI().use('slider', function (Y) {
            var maxSlider = new Y.Slider({
                min: 1,
                max: 200,
                value: 1
            });

            maxSlider.on("valueChange", function (e) {
                <portlet:namespace />maxValue = e.newVal;
                if (<portlet:namespace />heatMap) {
                    <portlet:namespace />heatMap.setDataMax(e.newVal);
                }
            });
            maxSlider.render('#<portlet:namespace />maxSlider');

            var jitterSlider = new Y.Slider({
                min: 0,
                max: 50,
                value: 25
            });

            jitterSlider.on("valueChange", function (e) {
                console.log("setting jitter to " + e.newVal);
                <portlet:namespace />jitter = e.newVal;
            });
            jitterSlider.render('#<portlet:namespace />jitterSlider');
        });

    }

    function <portlet:namespace />resetHeatmap() {
        if (<portlet:namespace />realtimeInterval) {
            clearInterval(<portlet:namespace />realtimeInterval);
            <portlet:namespace />realtimeInterval = null;
        }

        if (<portlet:namespace />replayTimer) {
            clearTimeout(<portlet:namespace />replayTimer);
            <portlet:namespace />replayTimer = null;
        }

        if (<portlet:namespace />heatMap != null) {
            <portlet:namespace />heatMap.setData({
                data: []
            });
        }
        document.getElementById('<portlet:namespace />visitorList').innerHTML = '';

        document.getElementById('<portlet:namespace />replayMarker').innerHTML = '';

        document.getElementById('<portlet:namespace />heatmapContainer').innerHTML = '';

        <portlet:namespace />heatMap = h337.create({
            container: document.getElementById('<portlet:namespace />heatmapContainer'),
            backgroundColor: 'rgba(0,0,0,.10)',
            blur: 1,
            gradient: {
                '.5': 'blue',
                '.8': 'red',
                '.95': 'white'
            },
            maxOpacity: .9,
            minOpacity: .3
        });
    }

    function <portlet:namespace />renderVisitorNames(visitors, id) {
        var visitorHtml =  '<span>';
        for (var i = 0; i < visitors.length; i++) {
        	visitorHtml = visitorHtml + (visitors[i] + '<br>');
        }
		visitorHtml += '</span>';
        document.getElementById(id).innerHTML = visitorHtml;
    }

    function <portlet:namespace />staticHeatmap() {
        <portlet:namespace />resetHeatmap();

        <portlet:namespace />auiXmlHttpRequest('<%= getAllExhibitsURL %>', null, function (visits) {
            <portlet:namespace />heatMap.setData({
                min: 0,
                max: <portlet:namespace />maxValue,
                data: <portlet:namespace />getDataPoints(visits)
            });
            <portlet:namespace />renderVisitorNames(visits.visitors.sort(), '<portlet:namespace />visitorList');
            var visitors = visits.visitors;
            visitors.sort();

        }, function (err) {
            console.log("ERROR: " + err);
        });
    };

    function <portlet:namespace />realtimeHeatmap() {

        <portlet:namespace />resetHeatmap();

        if (<portlet:namespace />replayCumulativeFlag) {
            <portlet:namespace />heatMap.setDataMax(<portlet:namespace />maxValue);
            <portlet:namespace />heatMap.setDataMin(0);
        }

        <portlet:namespace />realtimeInterval = setInterval(function () {

            <portlet:namespace />auiXmlHttpRequest('<%= getExhibitsURL %>', null, function (visits) {
                if (!visits || !visits.visits || visits.visits.length <= 0) return;
                if (<portlet:namespace />replayCumulativeFlag) {
                    <portlet:namespace />heatMap.addData(<portlet:namespace />getDataPoints(visits));
                } else {
                    <portlet:namespace />heatMap.setData({
                        min: 0,
                        max: <portlet:namespace />maxValue,
                        data: <portlet:namespace />getDataPoints(visits)
                    });
                    <portlet:namespace />renderVisitorNames(visits.visitors.sort(), '<portlet:namespace />visitorList');
                }
            }, function (err) {
                console.log("ERROR: " + err);
            });
        }, 100);
    }

    function <portlet:namespace />replayHeatmap() {

        <portlet:namespace />resetHeatmap();

        if (<portlet:namespace />replayCumulativeFlag) {
            <portlet:namespace />heatMap.setDataMax(<portlet:namespace />maxValue);
            <portlet:namespace />heatMap.setDataMin(0);
        }

        // get all hits in last x secs
        <portlet:namespace />auiXmlHttpRequest('<%= getReplayExhibitsURL %>', null, function (visits) {
            if (!visits || !visits.visits || visits.visits.length <= 0) return;
            visits.visits.sort(function (a, b) {
                return (a.time - b.time)
            });
            // calculate head interval for a smooth 10-second playback at 10fps
            // which means 100ms per frame, for 100 total frames.
            var replayHeadInterval = <%= (replayLimit * 1000) / 100 %>;

            var now = new Date().getTime();
            var marker = document.getElementById('<portlet:namespace />replayMarker');

            <portlet:namespace />renderVisitorNames(visits.visitors.sort(), '<portlet:namespace />visitorList');

            
            <portlet:namespace />replayTime(visits, now, -1, 0, replayHeadInterval, marker);

        });
    }

    function <portlet:namespace />replayTime(visits, curTime, lastPlottedIndex, replayHead, replayHeadInterval, marker) {

        var newVisits = {
            visits: [],
            config: visits.config
        };


        if (replayHead >= 100) {
            <portlet:namespace />heatMap.setData({
                min: 0,
                max: <portlet:namespace />maxValue,
                data: []
            });
            <portlet:namespace />replayTime(visits, curTime, -1, 0, replayHeadInterval, marker);
            return;
        }

        var startTime = curTime - ((100 - replayHead) * replayHeadInterval);
        var endTime = startTime + replayHeadInterval;
        var newLastPlotted = lastPlottedIndex;

        if (marker) marker.textContent = new Date(startTime);
        for (var i = lastPlottedIndex + 1; i < visits.visits.length; i++) {
            var visit = visits.visits[i];
            if (visit.time >= startTime && visit.time <= endTime) {
                newVisits.visits.push(visit);
                newLastPlotted = i;
            } else if (visit.time > endTime) {
                break;
            }
        }

        // show the frame of data
        if (<portlet:namespace />replayCumulativeFlag) {
            <portlet:namespace />heatMap.addData(<portlet:namespace />getDataPoints(newVisits));
            <portlet:namespace />heatMap.setDataMax(<portlet:namespace />maxValue);
        } else {
            // show frame and overwrite previous
            <portlet:namespace />heatMap.setData({
                min: 0,
                max: <portlet:namespace />maxValue,
                data: <portlet:namespace />getDataPoints(newVisits)
            });
        }

        // advance to next frame or reset
        <portlet:namespace />replayTimer = setTimeout(function () {
            <portlet:namespace />replayTime(visits, curTime, newLastPlotted, replayHead + 1, replayHeadInterval, marker);
        }, 100);

    }

    // {
    //   config: [{exhibitName: "foo", x: 1, y: 2}, ...],
    //   visits: [ {name: exhibitName, proximity: prox}, ... ]
    // }
    function <portlet:namespace />getDataPoints(visits) {

        var datapoints = [];
        var hash = {};
        for (var i = 0; i < visits.config.length; i++) {
            hash[visits.config[i].exhibitName] = visits.config[i];
        }
        for (var i = 0; i < visits.visits.length; i++) {
            var visit = visits.visits[i];
            var loc = hash[visit.name];
            if (!loc) continue;
            var val = <portlet:namespace />getValueForProximity(visit.proximity);
            var xJitter = <portlet:namespace />jitter;
            var yJitter = <portlet:namespace />jitter * 0.5;
            if (Math.random() > .5) {
                xJitter *= -1;
            }
            if (Math.random() > .5) {
                yJitter *= -1;
            }

            datapoints.push({
                x: loc.x + (xJitter * Math.random()),
                y: loc.y + (yJitter * Math.random()),
                value: val
            });
        }
        return datapoints;
    }

    function <portlet:namespace />getValueForProximity(proximity) {
        if (proximity === '<%= ProximityLevel.IMMEDIATE.name() %>') return 10;
        else if (proximity === '<%= ProximityLevel.NEAR.name() %>') return 5;
        else if (proximity === '<%= ProximityLevel.FAR.name() %>') return 2;
        else return 0;
    }

    function <portlet:namespace />auiXmlHttpRequest(url, data, onSuccess, onError) {
        AUI().use(
                "aui-base", "aui-io-plugin", "aui-io-request",
                function (A) {
                    A.io.request(
                        url,
                        {
                            data: data ? data : "",
                            dataType: "json",
                            on: {
                                success: function () {
                                    var raw = this.get('responseData');
                                    try {
                                        onSuccess(raw);
                                    } catch (ex) {
                                        onError("Invalid data returned, starting with " + raw.substring(0, 10) + "...");
                                    }
                                },
                                failure: function () {
                                    onError("Unable to retrieve results");
                                }
                            }
                        }
                    );
                }
        );
    }

</script>

