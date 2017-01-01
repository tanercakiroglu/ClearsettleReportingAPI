package com.clearsettle.exception;

/**
 * 
 * @author taner cakiroglu
 * @comment catch bussines logic exception
 *
 */
public class BussinesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public BussinesException () {

	    }

	    public BussinesException (String message) {
	        super (message);
	    }

	    public BussinesException (Throwable cause) {
	        super (cause);
	    }

	    public BussinesException (String message, Throwable cause) {
	        super (message, cause);
	    }

}
