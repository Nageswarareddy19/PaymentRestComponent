package com.payment.exceptions;

public class TranscationFailedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1609846838007175510L;

	public TranscationFailedException(String msg) {
		super(msg);
	}

}
