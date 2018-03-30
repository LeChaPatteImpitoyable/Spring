package com.ying.xman.test;

import com.ying.xman.backend.api.action.TestAction;
import com.ying.xman.backend.api.framework.Api;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class BaseTest implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    @Test
    public void test(){
       if(applicationContext == null){
           System.out.println("application context is null!");
       }else{
           TestAction testAction = applicationContext.getBean(TestAction.class);
           System.out.println("testAction == null:"+(testAction == null));
           Map<String, Api> map = applicationContext.getBeansOfType(Api.class);
           System.out.println("map == null:"+(map == null)+" size:"+ (map != null?map.size():0));
       }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
