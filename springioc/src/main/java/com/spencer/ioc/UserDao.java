package com.spencer.ioc;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by 沾雨 on 2017/7/5 上午10:21
 */
public class UserDao implements UserDaoInterface ,InitializingBean{
    public void add() {
        System.out.println("dao add");

    }

    public void update() {
        System.out.println("update dao");
    }

    public void select() {
        System.out.println("select dao");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("UserDao afterPropertiesSet ");
    }
}
