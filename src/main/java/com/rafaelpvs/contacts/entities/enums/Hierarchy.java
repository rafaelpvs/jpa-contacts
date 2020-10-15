package com.rafaelpvs.contacts.entities.enums;

public enum Hierarchy {
	PRIMARY(1),
	SECONDARY(2);
	
	private int code;
	
	private Hierarchy(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static Hierarchy valueOf(int code) {
		for(Hierarchy value : Hierarchy.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Hierarchy code");
	}
}
