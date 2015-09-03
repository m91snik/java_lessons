package com.m91snik.lesson15.rest.repository;

import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String>{

    UserEntity save(UserEntity userEntity);

    UserEntity findByNameAndPassword(String name, String password);

    UserEntity findByName(String name);

    List<UserEntity> findAllByUserType(UserType userType);
}
