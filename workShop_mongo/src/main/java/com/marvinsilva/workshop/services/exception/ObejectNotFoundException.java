package com.marvinsilva.workshop.services.exception;

public class ObejectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObejectNotFoundException(String mgn) {
		super(mgn);
	}

}
