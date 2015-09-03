package com.m91snik.lesson15.rest.repository.impl;

import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.repository.UserRepository;
import com.m91snik.lesson15.rest.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() throws Exception {
        UserEntity userEntity = saveUser();
        UserEntity foundUser = findUserById(userEntity);

        Assert.assertEquals(userEntity.getId(), foundUser.getId());
        Assert.assertEquals(userEntity.getName(), foundUser.getName());
        Assert.assertEquals(userEntity.getPassword(), foundUser.getPassword());
        Assert.assertEquals(userEntity.getUserType(), foundUser.getUserType());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserEntity findUserById(UserEntity userEntity) {
        return userRepository.findOne(userEntity.getId());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public UserEntity saveUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Nick");
        userEntity.setPassword("123");
        userEntity.setUserType(UserType.REGULAR);

        return userRepository.save(userEntity);
    }

    @Test
    public void testFindByNameAndPassword() throws Exception {
        UserEntity user = userRepository.findByNameAndPassword("Nick", "12345");
        Assert.assertNotNull(user);
        Assert.assertEquals("Nick", user.getName());
        Assert.assertEquals("12345", user.getPassword());
    }

    @Test
    public void testFindByNameAndPasswordNegative() throws Exception {
        UserEntity user = userRepository.findByNameAndPassword("xxx", "yyy");
        Assert.assertNull(user);
    }
}