package com.ying.xman.backend.api.framework;

import com.ying.xman.backend.api.response.ApiResult;

/**
 * Api生命周期
 * Created by yingsy on 2018/3/28.
 */
public interface ApiLifecycle {

    ApiResult doApiLifecycle(ApiRequest req, Api<ApiRequest, ApiResult> api);
}
