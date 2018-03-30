package com.ying.xman.backend.api.framework;

import com.ying.xman.backend.api.response.ApiResult;

/**
 * Created by yingsy on 2018/3/27.
 */
public interface Api<N extends ApiRequest, M> {

    ApiResult doApi(N req) throws Exception;

//    Class<N> getRequestType();

   ApiInfo getApiInfo();
}
