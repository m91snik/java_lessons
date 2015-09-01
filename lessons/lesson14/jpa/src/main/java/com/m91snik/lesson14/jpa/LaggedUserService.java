package com.m91snik.lesson14.jpa;

import com.m91snik.lesson14.jpa.entity.UserEntity;

/**
 * Created by m91snik on 30.08.15.
 */
public interface LaggedUserService {
    UserEntity findUser();
    UserEntity save(UserEntity userEntity);
}
