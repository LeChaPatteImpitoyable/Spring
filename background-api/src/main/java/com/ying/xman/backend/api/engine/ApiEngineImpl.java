package com.ying.xman.backend.api.engine;

import com.ying.xman.backend.api.framework.Api;
import com.ying.xman.backend.api.framework.ApiLifecycle;
import com.ying.xman.backend.api.framework.ApiRegistry;
import com.ying.xman.backend.api.framework.ApiRequest;
import com.ying.xman.backend.api.response.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yingsy on 2018/3/27.
 */
@Component("apiEngine")
public class ApiEngineImpl implements ApiEngine {

    @Autowired
    private ApiRegistry apiRegistry;

    @Autowired
    private ApiLifecycle apiLifecycle;

    @Override
    public DispatchResult execute(ApiEngineRequest req) {
        DispatchResult dispatchResult = new DispatchResult();
        ApiRequest apiRequest = null;
        ApiResult apiResult = null;

        //获取api
        Api<ApiRequest, ApiResult> api = apiRegistry.getApi(req.getApiType(), req.getApiMethod());

        //获取请求
        apiRequest = req.getApiRequest();

        //执行api
        apiResult = apiLifecycle.doApiLifecycle(apiRequest, api);

        //返回结果
        dispatchResult.setApiResult(apiResult);

        return dispatchResult;
    }
}
