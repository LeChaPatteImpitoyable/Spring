package com.ying.xman.backend.common;

public class Constants {

	public static final String UTF8 = "UTF-8";
	public static final String TYPE = "type";
	public static final String METHOD = "method";
	public static final String PATH_SIGN = "/";
	public static final String QUERY_SIGN = "?";
	public static final String SEPARATE_SIGN = "&";
	public static final String KEY_VALUE_SIGN = ":";
	public static final String ELEMENT_REGEXP_SIGN = "\\|";
	public static final String POINT_REGEXP_SIGN = "\\.";
	public static final String POINT_SIGN = ".";
	public static final String SEMICOLON_SIGN = ";";
	public static final String TILDE_SIGN = "~";
	public static final String COMMA_SIGN = ",";
	public static final String RENMINBI_SIGN = "￥";
	public static final String ELLIPSIS_SIGN = "...";

	public static class HTTP_METHOD {
		public static final String POST = "POST";
		public static final String GET = "GET";
	}

	public static class HTTP_CONTENT_TYPE {
		public static final String HEAD_KEY = "Content-type";
		public static final String JSON = "application/json";
		public static final String BIN = "application/octet-stream";
		public static final String FORM = "application/x-www-form-urlencoded";
		public static final String PLAIN = "text/plain";
		public static final String XML = "text/xml";
		public static final String IMAGE = "image/png";
		public static final String HTML = "text/html";
		public static final String CHARSET = "charset";
	}

	public static class URL {
		public static final String TEST = "/test/action";
	}

}
