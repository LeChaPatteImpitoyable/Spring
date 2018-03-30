package com.ying.xman.backend.api.framework;

import com.ying.xman.backend.api.response.ApiResult;

/**
 * Created by yingsy on 2018/3/28.
 */
public interface ApiRegistry {

    Api<ApiRequest, ApiResult> getApi(String type, String methodName);

    void registryApi();
}
