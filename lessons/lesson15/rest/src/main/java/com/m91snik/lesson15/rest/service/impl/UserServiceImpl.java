package com.m91snik.lesson15.rest.service.impl;

import com.m91snik.lesson15.rest.entity.UserType;
import com.m91snik.lesson15.rest.converter.Converter;
import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.entity.UserEntity;
import com.m91snik.lesson15.rest.repository.UserRepository;
import com.m91snik.lesson15.rest.service.UserService;
import com.m91snik.lesson15.rest.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(String name, String password, UserType userType) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setUserType(userType);
        UserEntity userEntity = Converter.toUserEntity(user);
        userEntity.setPassword(PasswordUtils.getPasswordHash(user.getPassword(), user.getName()));
        return Converter.toUser(userRepository.save(userEntity));
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> allByUserType = userRepository.findAllByUserType(UserType.REGULAR);
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : allByUserType) {
            users.add(Converter.toUser(userEntity));
        }
        return users;
    }

    @Override
    public User findByNameAndPassword(String name, String password) {
        UserEntity userEntity = userRepository.findByNameAndPassword(name, password);
        return Converter.toUser(userEntity);
    }

    @Override
    public User findByName(String name) {
        UserEntity userEntity = userRepository.findByName(name);
        return Converter.toUser(userEntity);
    }

    @Override
    public User find(String userId) {
        return Converter.toUser(userRepository.findOne(userId));
    }

    @Override
    public void remove(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public User update(User user) {
        UserEntity userEntity = userRepository.findOne(user.getId());
        String password = PasswordUtils.getPasswordHash(user.getPassword(), userEntity.getName());
        if (!password.equals(userEntity.getPassword())) {
            throw new IllegalArgumentException("Password is invalid");
        }
        UserEntity userEntityToUpdate = Converter.toUserEntity(userEntity, user);
        userEntityToUpdate.setPassword(PasswordUtils.getPasswordHash(user.getPassword(), user.getName()));
        UserEntity updatedUserEntity = userRepository.save(userEntityToUpdate);
        return Converter.toUser(updatedUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username + " was not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(
                userEntity.getName(), userEntity.getPassword(), authorities);
    }


}
