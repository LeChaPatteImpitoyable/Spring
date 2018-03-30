package com.ying.xman.backend.api.engine;


import com.ying.xman.backend.api.response.ApiResult;

public class DispatchResult {

	private ApiResult apiResult = new ApiResult();

	/**
	 * Getter method for property <tt>apiResult</tt>.
	 * 
	 * @return property value of apiResult
	 */
	public ApiResult getApiResult() {
		return apiResult;
	}

	/**
	 * Setter method for property <tt>apiResult</tt>.
	 * 
	 * @param apiResult
	 *            value to be assigned to property apiResult
	 */
	public void setApiResult(ApiResult apiResult) {
		this.apiResult = apiResult;
	}

}
