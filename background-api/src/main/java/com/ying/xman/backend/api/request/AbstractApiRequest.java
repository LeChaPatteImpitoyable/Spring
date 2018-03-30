package com.ying.xman.backend.api.request;

import com.ying.xman.backend.api.framework.ApiRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by yingsy on 2018/3/28.
 */
@Getter
@Setter
public abstract class AbstractApiRequest implements ApiRequest{

    private String token;
}
