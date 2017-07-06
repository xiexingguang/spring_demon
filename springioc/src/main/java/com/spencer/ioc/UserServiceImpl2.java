package com.spencer.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by 沾雨 on 2017/7/5 下午11:21
 */
public class UserServiceImpl2 implements UserServiceInterface {


    @Autowired
    @Qualifier("userDao2")
    public UserDaoInterface userDaoInterface;

    public void add() {
        userDaoInterface.add();
    }

    public void update() {

    }

    public void select() {

    }
}
