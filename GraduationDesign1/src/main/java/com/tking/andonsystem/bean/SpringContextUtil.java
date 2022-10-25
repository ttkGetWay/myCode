package com.tking.andonsystem.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

//    public static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//
//    public  void setApplicationContext(ApplicationContext applicationContext){
//        SpringContextUtil.applicationContext = applicationContext;
//    }
//    public static Object getBean(String beanName) {
//        return applicationContext.getBean(beanName);
//    }
//    public static <T> T getBean(Class<T> cls) {
//        System.out.println(cls);
//        System.out.println("springContext"+applicationContext.getBean(cls));
//        return applicationContext.getBean(cls);
//    }
}
