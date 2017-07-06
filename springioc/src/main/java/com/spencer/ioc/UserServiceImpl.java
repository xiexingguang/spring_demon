package com.spencer.ioc;

/**
 * Created by 沾雨 on 2017/7/5 上午10:16
 */
public class UserServiceImpl implements UserServiceInterface {

    public UserDaoInterface userDao;



    //set方式注入
    public void setUserDao(UserDaoInterface userDao) {
        this.userDao = userDao;
    }



    public void add() {
        userDao.add();
        System.out.println("add method");
    }

    public void update() {
        userDao.update();
        System.out.println("update method");
    }

    public void select() {
        userDao.select();
        System.out.println("select method");
    }
}
