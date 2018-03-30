package com.ying.xman.backend.api.engine;

/**
 * Created by yingsy on 2018/3/27.
 */
public interface ApiEngine {

    DispatchResult execute(ApiEngineRequest req);
}
