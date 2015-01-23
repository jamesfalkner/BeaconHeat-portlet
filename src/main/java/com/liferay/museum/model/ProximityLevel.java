package com.liferay.museum.model;

public enum ProximityLevel {
	UNKNOWN,
	IMMEDIATE,
	NEAR,
	FAR;
	
	public static ProximityLevel proximityFromString(String proxStr) throws IllegalArgumentException {
		
		for (ProximityLevel p : values()) {
			if (proxStr != null && proxStr.equalsIgnoreCase(p.name())) {
				return p;
			}
		}
		
		throw new IllegalArgumentException(proxStr + " is not a valid proximity level");
	}
}

