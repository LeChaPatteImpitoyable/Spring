package com.ying.xman.backend.api.framework;

import com.alibaba.fastjson.JSON;
import com.ying.xman.backend.api.response.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yingsy on 2018/3/28.
 */
@Component("apiRegistry")
public class ApiRegistryImpl implements ApiRegistry, ApplicationContextAware, InitializingBean {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(ApiRegistryImpl.class);
    /**
     * spring 上下文
     * 通过实现ApplicationContextAware接口传入
     */
    private ApplicationContext applicationContext;

    /**
     * 所有Api action缓存实例
     */
    private final Map<String ,Api<ApiRequest, ApiResult>> apiMap = new HashMap<>();

    @Override
    public Api<ApiRequest, ApiResult> getApi(String type, String methodName) {
        String apiName = new StringBuilder().append("/").append(type).append("/").append(methodName).toString();
        LOG.info("---------apiName:"+apiName);
        return getApiAccurately(apiName);
    }

    protected Api getApiAccurately(String apiName){
        return apiMap.get(apiName);
    }

    @Override
    public void registryApi() {
        //获取Api的所有实现类的实例
        //接口必须在扫描范围内
        Map<String, Api> map = applicationContext.getBeansOfType(Api.class);
        LOG.info("--------Get Bean By Type Api:"+JSON.toJSONString(map));
        Set<String> beanNames = map.keySet();
        for (String beanName : beanNames) {
            Api api = map.get(beanName);
            //获取注解并获得名称
            ApiInfo apiInfo = api.getApiInfo();
            String name = apiInfo.name();
            //塞入apiMap缓存中
            apiMap.put(name, api);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 初始化bean
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        registryApi();
        LOG.info("--------API MAP:"+ JSON.toJSONString(apiMap));
    }
}
