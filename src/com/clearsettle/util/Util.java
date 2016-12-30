package com.clearsettle.util;

import com.google.gson.Gson;

public class Util {

	/**
	 * 
	 * @param txt
	 * @return boolean check string null or empty
	 */
	
	  public static boolean isNullOREmpty(String txt) {
	        return txt != null && txt.trim().length() > 0 ? false : true;
	    }
	  
	  /**
	     * Method to construct JSON
	     * 
	     * @param tag
	     * @param status
	     * @return
	     */
	    public static Object constructJSON(String tag, boolean status,Object response) {
	          Gson gson = null;
	          String json=null;
	        try {
	        	gson = new Gson();
	        	json = gson.toJson(response);

	        } catch (Exception e) {
	        }
	        return json;
	    }
}
