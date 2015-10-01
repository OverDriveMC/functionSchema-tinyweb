package com.mblinn.oo.tinyweb;

public class ControllerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private Integer statusCode;
	public ControllerException(Integer statusCode) {
		super();
		this.statusCode = statusCode;
	}
	public Integer getStatusCode(){
		return statusCode;
	}
}
