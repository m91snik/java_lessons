package com.lexsus.chat.base;

import com.lexsus.chat.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
@Service
@Transactional
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
    public UserEntity findUser(String userLogin){
        List<UserEntity> usersList = userDao.getUsers();
        for (UserEntity user:usersList) {
            //UserEntity user = userDao.findUser(userLogin);
            if (user.getName().equals(userLogin)) {
                return user;
            }
        }
        return null;
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
