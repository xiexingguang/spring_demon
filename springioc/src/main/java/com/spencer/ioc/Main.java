package com.spencer.ioc;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by 沾雨 on 2017/7/5 上午10:19
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring_ioc.xml"});

            UserServiceInterface userServiceInterface2 = (UserServiceInterface)context.getBean("anonotationService3");
            System.out.println(userServiceInterface2);

            userServiceInterface2.add();

        DemonBean demonBean = (DemonBean)context.getBean("demonBean");




    }

}
