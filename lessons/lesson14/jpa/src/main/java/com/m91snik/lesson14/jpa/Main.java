package com.m91snik.lesson14.jpa;

import com.m91snik.lesson14.jpa.entity.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by m91snik on 30.08.15.
 */
public class Main {



    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        UserDao userDao = applicationContext.getBean(UserDao.class);

        LaggedUserService laggedUserService = applicationContext.getBean(LaggedUserService.class);

        System.out.println(userDao.getUsers());

        new Thread(
                () -> {
                    saveUser(laggedUserService);
                }
        ).start();

        new Thread(
                () -> {
                    findUser(laggedUserService);
                }
        ).start();
    }

    @Transactional
    private static void findUser(LaggedUserService laggedUserService) {
        UserEntity user = laggedUserService.findUser();
        System.out.println(user);
    }

    @Transactional
    public static void saveUser(LaggedUserService laggedUserService) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("mike");
        userEntity.setPassword("1234");

        UserEntity saveUser = laggedUserService.save(userEntity);
    }
}
