package com.spencer.ioc;

import javax.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by 沾雨 on 2017/7/6 上午1:42
 */
public class DemonBean implements BeanFactoryPostProcessor,InitializingBean,BeanPostProcessor {

    private String p1 = "jasshine";

    private String p2 = "stone";

    @Autowired
    private UserDao userDao;

    public void before() {
        System.out.println("init-before was called");
    }

    public void after() {
        System.out.println("init-destory was called ");
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct 注解  执行");
    }

    public DemonBean() {
        System.out.println("DemonBean 构造函数执行");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanFactoryPostProcessor.afterPropertiesSet was called ");
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory ====》");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessBeforeInitialization was called ==>" + beanName);
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor.postProcessAfterInitialization was called ==>" + beanName);
        return null;
    }
}
