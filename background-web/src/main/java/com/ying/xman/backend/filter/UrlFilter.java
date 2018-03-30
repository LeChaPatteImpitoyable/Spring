package com.ying.xman.backend.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 * Created by yingsy on 2018/3/30.
 */
public class UrlFilter implements Filter {

    /** logger */
    private static final Logger LOG = LoggerFactory.getLogger(UrlFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;

        String uri = req.getRequestURI();
        LOG.info("--------Filter Url---------"+uri);
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
