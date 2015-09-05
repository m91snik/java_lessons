package com.m91snik.lesson15.rest.repository.impl;

import com.m91snik.lesson15.rest.entity.ExpensesEntity;
import com.m91snik.lesson15.rest.repository.ExpensesRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

//NOTE: show case test
public class ExpensesRepositoryTest extends BaseTest {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Test
    public void testSave() throws Exception {
        ExpensesEntity expensesEntity = saveUser();
        ExpensesEntity foundExpenses = findUserById(expensesEntity);

        Assert.assertEquals(expensesEntity.getId(), foundExpenses.getId());
        Assert.assertEquals(expensesEntity.getComment(), foundExpenses.getComment());
        Assert.assertEquals(expensesEntity.getAmount(), foundExpenses.getAmount());
        Assert.assertEquals(expensesEntity.getCreationTime(), foundExpenses.getCreationTime());
        Assert.assertEquals(expensesEntity.getCurrency(), foundExpenses.getCurrency());
        Assert.assertEquals(expensesEntity.getDescription(), foundExpenses.getDescription());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ExpensesEntity findUserById(ExpensesEntity expensesEntity) {
        return expensesRepository.findOne(expensesEntity.getId());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ExpensesEntity saveUser() {
        ExpensesEntity expensesEntity = new ExpensesEntity();
        expensesEntity.setAmount(53250);
        expensesEntity.setComment("comment1");
        expensesEntity.setCreationTime(new Date());
        expensesEntity.setOwnerId("id1");
        expensesEntity.setCurrency("RUB");
        expensesEntity.setDescription("descr1");

        return expensesRepository.save(expensesEntity);
    }

    //8632183800
//    8632013000
    @Test
    public void testFindTwoByOwnerIdAndCreationTimeBetween() throws Exception {
        List<ExpensesEntity> expenses = expensesRepository.findAllByOwnerIdAndCreationTimeBetween("id1",
                new Date(2015, 10, 11, 20, 31), new Date(2015, 10, 11, 22, 00));
    }

    @Test
    public void testEmptyFindAllByOwnerIdAndCreationTimeBetween() throws Exception {
        List<ExpensesEntity> expenses = expensesRepository.findAllByOwnerIdAndCreationTimeBetween("id2",
                new Date(2015, 10, 11, 20, 30), new Date(2015, 10, 11, 22, 00));
        Assert.assertEquals(0, expenses.size());
    }

    @Test
    public void testFindAllByOwnerIdAndCreationTimeLessThan() throws Exception {
        List<ExpensesEntity> expenses = expensesRepository.findAllByOwnerIdAndCreationTimeLessThan("id1",
                new Date(2015, 10, 11, 21, 31));
    }

}
