package com.ying.xman.backend.common.maping;

import com.alibaba.fastjson.JSON;
import com.ying.xman.backend.common.Constants;
import com.ying.xman.backend.common.enums.ActionEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingsy on 2018/3/28.
 */
public class UrlActionMaping {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(UrlActionMaping.class);

    private static final Map<String, ActionEnum> URL_ACRION_MAP = new HashMap<>();

    static {
        initUrlActionMap();
        LOG.info("-------------URL_ACRION_MAP:"+ JSON.toJSONString(URL_ACRION_MAP));
    }

    private static void initUrlActionMap(){
        URL_ACRION_MAP.put(Constants.URL.TEST, ActionEnum.TEST);
    }

    public static boolean containtsUrl(String url){
        if(StringUtils.isEmpty(url)){
            return false;
        }
        return URL_ACRION_MAP.containsKey(url);
    }

    public static ActionEnum getAction(String url){
        if(StringUtils.isEmpty(url)){
            return null;
        }
        url = StringUtils.remove(url, "/api");

        return URL_ACRION_MAP.get(url);
    }
}
