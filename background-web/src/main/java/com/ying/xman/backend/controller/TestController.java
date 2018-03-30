package com.ying.xman.backend.controller;

import com.ying.xman.backend.api.request.TestActionRequest;
import com.ying.xman.backend.api.response.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yingsy on 2018/3/27.
 */
@Controller
public class TestController extends AbstractController{

    @RequestMapping("/test/action")
    @ResponseBody
    public ApiResult test(String name, HttpServletRequest request, HttpServletResponse response){
        TestActionRequest req = new TestActionRequest();
        req.setName(name);
        return process(req,request,response);
    }

    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.html";
    }
}
