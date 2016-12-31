package com.clearsettle.configuration;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.input.TeeInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestFilterLogging implements Filter {

	private AtomicLong id = new AtomicLong(1);
	private static final String REQUEST_PREFIX = "Request: ";
	 private final static Logger logger = LoggerFactory.getLogger(RequestFilterLogging.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		long requestId = id.incrementAndGet();
		request = new RequestWrapper(requestId, req);
		try {
			chain.doFilter(request, response);
		} finally {
			logRequest(req);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public static class RequestWrapper extends HttpServletRequestWrapper {

		private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
		private long id;

		public RequestWrapper(Long requestId, HttpServletRequest request) {
			super(request);
			this.id = requestId;
		}

		@Override
		public ServletInputStream getInputStream() throws IOException {
			return new ServletInputStream() {

				private TeeInputStream tee = new TeeInputStream(RequestWrapper.super.getInputStream(), bos);

				@Override
				public int read() throws IOException {
					return tee.read();
				}
			};
		}

		public byte[] toByteArray() {
			return bos.toByteArray();
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
	}


	private void logRequest(final HttpServletRequest request) {
		StringBuilder msg = new StringBuilder();
		msg.append(REQUEST_PREFIX);
		if (request instanceof RequestWrapper) {
			msg.append("request id=").append(((RequestWrapper) request).getId()).append("; ");
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			msg.append("session id=").append(session.getId()).append("; ");
		}
		if (request.getMethod() != null) {
			msg.append("method=").append(request.getMethod()).append("; ");
		}
		if (request.getRemoteAddr() != null) {
			msg.append("remote=").append(request.getRemoteAddr()).append("; ");
		}
		if (request.getContentType() != null) {
			msg.append("content type=").append(request.getContentType()).append("; ");
		}
		msg.append("uri=").append(request.getRequestURI());
		if (request.getQueryString() != null) {
			msg.append('?').append(request.getQueryString());
		}

		if (request instanceof RequestWrapper && !isMultipart(request) && !isBinaryContent(request)) {
			RequestWrapper requestWrapper = (RequestWrapper) request;
			try {
				String charEncoding = requestWrapper.getCharacterEncoding() != null
						? requestWrapper.getCharacterEncoding() : "UTF-8";
				msg.append("; payload=").append(new String(requestWrapper.toByteArray(), charEncoding));
			} catch (UnsupportedEncodingException e) {
			}

		}
		logger.debug(msg.toString());
	}

	private boolean isBinaryContent(final HttpServletRequest request) {
		if (request.getContentType() == null) {
			return false;
		}
		return request.getContentType().startsWith("image") || request.getContentType().startsWith("video")
				|| request.getContentType().startsWith("audio");
	}

	private boolean isMultipart(final HttpServletRequest request) {
		return request.getContentType() != null && request.getContentType().startsWith("multipart/form-data");
	}
}
