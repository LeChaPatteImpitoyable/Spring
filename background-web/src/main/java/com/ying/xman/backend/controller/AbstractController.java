package com.ying.xman.backend.controller;

import com.alibaba.fastjson.JSON;
import com.ying.xman.backend.api.engine.ApiEngine;
import com.ying.xman.backend.api.engine.ApiEngineRequest;
import com.ying.xman.backend.api.engine.DispatchResult;
import com.ying.xman.backend.api.framework.ApiRequest;
import com.ying.xman.backend.api.response.ApiResult;
import com.ying.xman.backend.common.Constants;
import com.ying.xman.backend.common.enums.ActionEnum;
import com.ying.xman.backend.common.maping.UrlActionMaping;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by yingsy on 2018/3/27.
 */
public abstract class AbstractController implements IController {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(AbstractController.class);

    @Autowired
    private ApiEngine apiEngine;

    @Override
    public Map<String, String> getAction(HttpServletRequest request) {
        String uri = request.getRequestURI();
        LOG.info("---------------Request Uri:"+uri);
        if(StringUtils.isEmpty(uri)){
            return null;
        }
        ActionEnum actionEnum = UrlActionMaping.getAction(uri);
        return ActionEnum.getAction(actionEnum);
    }

    public ApiResult process(ApiRequest apiRequest, HttpServletRequest request, HttpServletResponse response){
        //1.组装数据
        ApiEngineRequest apiEngineRequest = new ApiEngineRequest();

        //2.获取action
        Map<String, String> map = this.getAction(request);
        LOG.info("-----------map:"+ JSON.toJSONString(map));
        apiEngineRequest.setApiRequest(apiRequest);
        apiEngineRequest.setApiType(map.get(Constants.TYPE));
        apiEngineRequest.setApiMethod(map.get(Constants.METHOD));

        //token

        //3.调用服务
        DispatchResult dispatchResult = apiEngine.execute(apiEngineRequest);
        return dispatchResult.getApiResult();
    }
}
