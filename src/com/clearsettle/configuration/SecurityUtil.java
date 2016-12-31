package com.clearsettle.configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.clearsettle.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SecurityUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static void sendError(HttpServletResponse response, Exception exception, int status, String message)
			throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(status);
		PrintWriter writer = response.getWriter();
		writer.write(mapper
				.writeValueAsString(Util.constructJSON(message, exception.getMessage())));
		writer.flush();
		writer.close();
	}

	public static void sendResponse(HttpServletResponse response, int status, Object object) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write(mapper.writeValueAsString(object));
		response.setStatus(status);
		writer.flush();
		writer.close();
	}

}
