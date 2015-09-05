package com.lexsus.chat.base;

import com.lexsus.chat.entity.UserEntity;

import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
public interface UserDao {
    UserEntity save(UserEntity userEntity);

    List<UserEntity> getUsers();

    UserEntity findUser(String id);
}
