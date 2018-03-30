package com.ying.xman.backend.api.framework;

import com.ying.xman.backend.api.response.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yingsy on 2018/3/28.
 */
@Component("apiLifecycle")
public class ApiLifecycleImpl implements ApiLifecycle {

    private final static Logger log = LoggerFactory.getLogger(ApiLifecycleImpl.class);

    @Override
    public ApiResult doApiLifecycle(ApiRequest req, Api<ApiRequest, ApiResult> api) {

        ApiResult result = new ApiResult();
        try {
            result = api.doApi(req);
        }catch (Exception e){
            log.error("---------------------Exception Log------------------------\n",e);
            result.setErrorCode("500");
            result.setErrorMsg("System Error");
        }
        return result;
    }
}
