package com.payment.exceptions;

import java.util.Date;

public class ErrorResponse {
	
	private String errorCode;
	private String errorDescription;
	private Date date;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ErrorResponse [errorCode=" + errorCode + ", errorDescription=" + errorDescription + ", date=" + date
				+ "]";
	} 
	
	
	

}
