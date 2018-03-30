package com.ying.xman.backend.common.enums;

import com.ying.xman.backend.common.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingsy on 2018/3/28.
 */
public enum ActionEnum {

    TEST("/action/test", "1.0.0");

    private String name;

    private String version;

    ActionEnum(String name, String version){
        this.setName(name);
        this.setVersion(version);
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static Map<String, String> getAction(ActionEnum actionEnum){
        if (actionEnum == null){
            return null;
        }
        String[] strs = actionEnum.getName().split(Constants.PATH_SIGN);
        Map<String, String> map = new HashMap<>();
        map.put(Constants.TYPE, strs[1]);
        map.put(Constants.METHOD, strs[2]);
        return map;
    }
}
