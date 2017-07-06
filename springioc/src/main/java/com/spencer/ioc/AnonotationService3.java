package com.spencer.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 沾雨 on 2017/7/5 下午11:54
 */


public class AnonotationService3 implements UserServiceInterface {

    @Autowired
    public UserDaoInterface userDao;



    //set方式注入
    public void setUserDao(UserDaoInterface userDao) {
        this.userDao = userDao;
    }


    public void add() {
       // interace1.sayHello();
        System.out.println();
         userDao.add();
    }

    public void update() {

    }

    public void select() {

    }
}
