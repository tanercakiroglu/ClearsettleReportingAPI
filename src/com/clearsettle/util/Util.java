package com.clearsettle.util;

import com.clearsettle.response.domain.ErrorResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
	     * Method to construct JSON with Error Msg
	     * 
	     * @param tag
	     * @param err_msg
	     * @return
	     */
	    public static Object constructJSON(String tag,Object err_mss) {
	         Gson gson = null;
	         ErrorResponse error=null;
	         String json=null;
	        try {
	        	gson = new GsonBuilder().serializeNulls().create();
	        	error = new ErrorResponse(tag,err_mss);
	            json = gson.toJson(error);
	        } catch (Exception e) {
	        }
	        return json;
	    }
	  /**
	     * Method to construct JSON
	     * 
	     * @param tag
	     * @param status
	     * @return
	     */
	    public static String constructJSON(String tag, boolean status,Object response) {
	          Gson gson = null;
	          String json=null;
	        try {
	        	gson = new GsonBuilder().serializeNulls().create();
	        	json = gson.toJson(response);

	        } catch (Exception e) {
	        }
	        return json;
	    }
}
