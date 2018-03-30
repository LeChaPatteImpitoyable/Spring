package com.ying.xman.backend.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yingsy on 2018/3/27.
 */
public interface IController {

    Map<String, String> getAction(HttpServletRequest request);
}
