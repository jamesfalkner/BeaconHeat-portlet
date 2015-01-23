<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.museum.model.ProximityLevel"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.museum.service.GalleryVisitLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.museum.model.GalleryVisit"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.liferay.museum.model.ExhibitVisit"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.museum.service.ExhibitVisitLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<%
	
    DynamicQuery q = DynamicQueryFactoryUtil.forClass(
            GalleryVisit.class, PortletClassLoaderUtil.getClassLoader());
    q.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("galleryName")));
    List<String> galNames = (List<String>) GalleryVisitLocalServiceUtil.dynamicQuery(q);

	for (String galName : galNames) {
	    // [GalleryName, [proximity, [TimeBucket, [id, id, id]]]]
	    Map<String, Map<ProximityLevel, Map<Long, Set<String>>>> galleryPings = new HashMap<String, Map<ProximityLevel, Map<Long, Set<String>>>>();
	    List<ExhibitVisit> galExhVisits = ExhibitVisitLocalServiceUtil.getExhibitVisitsByGalleryName(galName);
	    if (Validator.isNull(galExhVisits) || galExhVisits.size() <= 0) {
	    	%><h1>No visits recorded for Gallery <%= HtmlUtil.escape(galName) %></h1> <%
	    	continue;
	    }
	    long firstDate = galExhVisits.get(0).getCreateDate().getTime();
	    long lastDate = galExhVisits.get(galExhVisits.size() - 1).getCreateDate().getTime();
	    
	    // 1 minute buckets
	    long lastBucket = (lastDate - firstDate) / (1 * 60 * 1000);
	    
	    for (ExhibitVisit visit : galExhVisits) {
	    	long timeBucket = (visit.getCreateDate().getTime() - firstDate) / (1 * 60 * 1000);
	    	String visitorId = visit.getVisitorId();
	    	ProximityLevel prox = ProximityLevel.proximityFromString(visit.getProximity());
            Map<ProximityLevel, Map<Long, Set<String>>> galMap = galleryPings.get(galName);
            if (galMap != null) {
                Map<Long, Set<String>> beacTimes = galMap.get(prox);
                if (beacTimes != null) {
                    Set<String> beacProxs = beacTimes.get(timeBucket);
                    if (beacProxs != null) {
                        beacProxs.add(visitorId);
                    } else {
                        beacProxs = new HashSet<String>();
                        beacProxs.add(visitorId);
                        beacTimes.put(timeBucket, beacProxs);
                    }
                } else {
                    beacTimes = new HashMap<Long, Set<String>>();
                    Set<String> newSet = new HashSet<String>();
                    newSet.add(visitorId);
                    beacTimes.put(timeBucket, newSet);
                    galMap.put(prox, beacTimes);
                }
            } else {
            	galMap = new HashMap<ProximityLevel, Map<Long, Set<String>>>();
                Map<Long, Set<String>> newBeacs = new HashMap<Long, Set<String>>();
                Set<String> newSet = new HashSet<String>();
                newSet.add(visitorId);
                newBeacs.put(timeBucket, newSet);
                galMap.put(prox, newBeacs);
                galleryPings.put(galName, galMap);
            }

	    }


%>
		<div id="galcontainer-<%=galName.hashCode()%>" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<script type="text/javascript">
		
	    $(function () {
	        $('#galcontainer-<%=galName.hashCode()%>').highcharts({
	            chart: {
	                type: 'area',
	                zoomType: 'x',
	                spacingRight: 20
	            },
	            title: {
	                text: 'Exhibit Visits at Gallery: <%= galName %>',
	                x: -20 //center
	            },
	            subtitle: {
	                text: 'Browse the times!',
	                x: -20
	            },
	            xAxis: {
	                type: 'datetime',
	                maxZoom: 60 * 60 * 1000, // 1 hour
	                title: {
	                    text: "Time of Day"
	                }
	            },
	            yAxis: {
	                title: {
	                    text: 'Number of visitors'
	                }
	            },
	            tooltip: {
	                valueSuffix: ' visits'
	            },
	            legend: {
	                layout: 'vertical',
	                align: 'right',
	                verticalAlign: 'middle',
	                borderWidth: 0
	            },
	            plotOptions: {
	                area: {
	                    stacking: 'normal',
	                    lineColor: '#666666',
	                    lineWidth: 1,
	                    marker: {
	                        lineWidth: 1,
	                        lineColor: '#666666'
	                    }
	                }
	            },
	            series:
	                    [
	                        <%
	            			// [ExhibitName, [proximity, [TimeBucket, [id, id, id]]]]
	                        Map<ProximityLevel, Map<Long, Set<String>>> pings = galleryPings.get(galName);

	                        Iterator<ProximityLevel> it = pings.keySet().iterator();
	                        while (it.hasNext()) {
	                            ProximityLevel prox = it.next();
	                            String proxName = prox.name();

                            %>
                            
	                        {
	                            name: 'Proximity: <%= HtmlUtil.escapeJS(proxName) %>',
	                            pointInterval: 1 * 60 * 1000,
	                            pointStart: <%= firstDate %>,
	                            data: [
	                                <%
	                                Map<Long, Set<String>> graphPings = pings.get(prox);
	                                for (long i = 0; i <= lastBucket; i++) {
	                                    Set<String> pingRaw = graphPings.get(i);
	                                    if (pingRaw != null) {
	                                        %> <%= pingRaw.size() %> <%
	                            		} else {
	                               			%> 0 <%
	                           			}
			                            if (i < lastBucket) {
			                                %> , <%
			                            }
	                        		}
	                        %> ]
	                        }
	                        <% if (it.hasNext()) {
	                            %> , <%
	                        }
	                    }
	                      %> ]
	        });
	    });



		</script>


<%
	}
%>