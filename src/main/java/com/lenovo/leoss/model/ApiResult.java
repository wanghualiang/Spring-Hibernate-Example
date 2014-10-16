package com.lenovo.leoss.model;

public class ApiResult {
	
	private String result;
	private String message;

	public ApiResult(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}
	

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
