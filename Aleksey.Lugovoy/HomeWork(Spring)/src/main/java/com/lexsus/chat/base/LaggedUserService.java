package com.lexsus.chat.base;


import com.lexsus.chat.entity.UserEntity;

/**
 * Created by m91snik on 30.08.15.
 */
public interface LaggedUserService {
    UserEntity findUser();
    UserEntity findUser(String userLogin);
    UserEntity save(UserEntity userEntity);
}
