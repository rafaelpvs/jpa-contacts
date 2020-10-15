package com.rafaelpvs.contacts.entities.enums;

public enum Marker {
	CELLPHONE(1),
	RESIDENTIAL(2),
	WORK(3);
	
	private int code;
	
	private Marker(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Marker valueOf(int code) {
		for(Marker value : Marker.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Marker code");
	}
}
