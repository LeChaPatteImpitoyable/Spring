package com.ying.xman.backend.api.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by yingsy on 2018/3/28.
 */
@Getter
@Setter
public class ApiResult<T> implements Serializable {


    private static final long serialVersionUID = 744525287223062022L;
    private boolean success = false;

    private String errorCode;

    private String errorMsg;

    private  String token;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
