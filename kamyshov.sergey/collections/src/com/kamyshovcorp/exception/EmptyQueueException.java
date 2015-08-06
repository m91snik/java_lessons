package com.kamyshovcorp.exception;

/**
 * @author kamyshov.sergey
 * @since 06.08.2015
 */
public class EmptyQueueException extends RuntimeException {

	public EmptyQueueException() {
	}

	public EmptyQueueException(String message) {
		super(message);
	}

}
