package com.spencer.ioc;

import org.springframework.stereotype.Component;

/**
 * Created by 沾雨 on 2017/7/5 下午11:06
 */
@Component
public class UserDao2 implements UserDaoInterface {
    public void add() {
        System.out.println("userdao 2");
    }

    public void update() {
        System.out.println("userdao 2");
    }

    public void select() {

    }
}
