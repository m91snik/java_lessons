package com.m91snik.lesson14.jpa.impl;

import com.m91snik.lesson14.jpa.LaggedUserService;
import com.m91snik.lesson14.jpa.UserDao;
import com.m91snik.lesson14.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by m91snik on 30.08.15.
 */
@Service
@Transactional //(isolation = Isolation.READ_COMMITTED)
public class LaggedUserServiceImpl implements LaggedUserService {

    @Autowired
    private UserDao userDao;

    String savedUserId;

    @Override
    public UserEntity findUser() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        UserEntity user = userDao.findUser(savedUserId);
        return user;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        UserEntity savedUser = userDao.save(userEntity);
        savedUserId = savedUser.getId();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return savedUser;
    }
}
