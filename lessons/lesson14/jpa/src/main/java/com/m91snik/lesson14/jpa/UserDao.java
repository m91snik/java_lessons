package com.m91snik.lesson14.jpa;

import com.m91snik.lesson14.jpa.entity.UserEntity;

import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
public interface UserDao {
    UserEntity save(UserEntity userEntity);

    List<UserEntity> getUsers();

    UserEntity findUser(String id);
}
