package com.liferay.museum.model;

import java.io.Serializable;


public class ExhibitPing implements Cloneable, Serializable {

	private static final long serialVersionUID = -1184646960338848734L;
	private String exhibitName;
	private ProximityLevel proximity;
	
	public ExhibitPing() {
	}
	
	public ExhibitPing(String exhibitName, ProximityLevel proximity) {
		this.exhibitName = exhibitName;
		this.proximity = proximity;
	}

	public void setExhibitName(String exhibitName) {
		this.exhibitName = exhibitName;
	}
	
	public void setProximity(ProximityLevel proximity) {
		this.proximity = proximity;
	}
		
	public String getExhibitName() {
		return exhibitName;
	}
	
	public ProximityLevel getProximity() {
		return proximity;
	}
	
}
