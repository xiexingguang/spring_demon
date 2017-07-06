package com.spencer.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 沾雨 on 2017/7/6 上午1:26
 */
@Configuration
public class Factory {

    @Bean
    public UserDaoInterface getUserDao() {
        return new UserDao();
    }

    @Bean
    public UserDaoInterface getUserDao2() {
        return new UserDao2();
    }

    @Bean
    public Interace1 getInter() {
        return new A();
    }
}
