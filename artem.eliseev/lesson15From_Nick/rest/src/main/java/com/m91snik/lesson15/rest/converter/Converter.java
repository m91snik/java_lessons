package com.m91snik.lesson15.rest.converter;

import com.m91snik.lesson15.rest.dto.Expenses;
import com.m91snik.lesson15.rest.dto.User;
import com.m91snik.lesson15.rest.entity.ExpensesEntity;
import com.m91snik.lesson15.rest.entity.UserEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by m91snik on 10.08.15.
 */
public class Converter {

    public static final String EXPENSES_TIME_FORMAT = "dd.MM.yyyy kk:mm";
    public static final String USER_TIME_FORMAT = "dd.MM.yyyy kk:mm:ss";

    public static User toUser(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        String creationTime = new SimpleDateFormat(USER_TIME_FORMAT).format(userEntity.getCreationTime());
        user.setCreationDate(creationTime);
        user.setUserType(userEntity.getUserType());
//        user.setPassword(userEntity.getPassword());
        return user;
    }

    public static UserEntity toUserEntity(User user) {
        if (user == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        if (user.getId() != null) {
            userEntity.setId(user.getId());
        }
        userEntity.setName(user.getName());
        userEntity.setCreationTime(new Date());
        userEntity.setUserType(user.getUserType());
        userEntity.setPassword(user.getPassword());
        return userEntity;
    }

    public static UserEntity toUserEntity(UserEntity userEntity, User user) {
        if (user == null) {
            return userEntity;
        }
        userEntity.setName(user.getName());
        userEntity.setUserType(user.getUserType());
        return userEntity;
    }


    public static ExpensesEntity toExpensesEntity(Expenses expenses) {
        if (expenses == null) {
            return null;
        }
        ExpensesEntity expensesEntity = new ExpensesEntity();
        expensesEntity.setAmount(expenses.getAmount());
        expensesEntity.setCurrency(expenses.getCurrency());
        expensesEntity.setDescription(expenses.getDescription());
        expensesEntity.setComment(expenses.getComment() == null ? "" : expenses.getComment());
        expensesEntity.setOwnerId(expenses.getOwnerId());
        Date creationTime = null;
        try {
            creationTime = new SimpleDateFormat(EXPENSES_TIME_FORMAT).parse(expenses.getCreationTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        expensesEntity.setCreationTime(creationTime);
        return expensesEntity;
    }

    public static ExpensesEntity toExpensesEntity(ExpensesEntity expensesEntity, Expenses expenses) {
        if (expenses == null) {
            return expensesEntity;
        }
        expensesEntity.setAmount(expenses.getAmount());
        expensesEntity.setCurrency(expenses.getCurrency());
        expensesEntity.setDescription(expenses.getDescription());
        expensesEntity.setComment(expenses.getComment() == null ? "" : expenses.getComment());
        expensesEntity.setOwnerId(expenses.getOwnerId());
        Date creationTime = null;
        try {
            creationTime = new SimpleDateFormat(EXPENSES_TIME_FORMAT).parse(expenses.getCreationTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        expensesEntity.setCreationTime(creationTime);
        return expensesEntity;
    }

    public static Expenses toExpenses(ExpensesEntity expensesEntity) {
        if (expensesEntity == null) {
            return null;
        }
        Expenses expenses = new Expenses();
        expenses.setId(expensesEntity.getId());
        expenses.setAmount(expensesEntity.getAmount());
        expenses.setCurrency(expensesEntity.getCurrency());
        expenses.setDescription(expensesEntity.getDescription());
        expenses.setComment(expensesEntity.getComment());
        String creationTime = new SimpleDateFormat(EXPENSES_TIME_FORMAT).format(expensesEntity.getCreationTime());

        expenses.setCreationTime(creationTime);
        expenses.setOwnerId(expensesEntity.getOwnerId());
        return expenses;
    }
}
