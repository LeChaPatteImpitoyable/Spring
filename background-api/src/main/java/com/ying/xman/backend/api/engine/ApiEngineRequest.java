package com.ying.xman.backend.api.engine;


import com.ying.xman.backend.api.framework.ApiRequest;

import java.io.Serializable;

/**
 * API 引擎的请求
 */
public class ApiEngineRequest implements Serializable {

	/**  */
	private static final long serialVersionUID = 1559508742426596254L;

	/**
	 *API类型
	 */
	private String apiType;

	/**
	 *API的方法
	 */
	private String apiMethod;

	/**
	 * API 请求
	 */
	private ApiRequest apiRequest;

	public String getApiType() {
		return apiType;
	}

	public void setApiType(String apiType) {
		this.apiType = apiType;
	}

	public String getApiMethod() {
		return apiMethod;
	}

	public void setApiMethod(String apiMethod) {
		this.apiMethod = apiMethod;
	}

	public ApiRequest getApiRequest() {
		return apiRequest;
	}

	public void setApiRequest(ApiRequest apiRequest) {
		this.apiRequest = apiRequest;
	}
}
