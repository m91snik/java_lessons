package com.m91snik.lesson15.rest.repository;

import com.m91snik.lesson15.rest.entity.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<ExpensesEntity, String> {

    ExpensesEntity save(ExpensesEntity expensesEntity);

    List<ExpensesEntity> findAllByOwnerIdAndCreationTimeBetween(String ownerId, Date start, Date end);

    List<ExpensesEntity> findAllByCreationTimeBetween(Date start, Date end);

    List<ExpensesEntity> findAllByOwnerIdAndCreationTimeLessThan(String ownerId, Date end);

    List<ExpensesEntity> findAllByCreationTimeLessThan(Date end);

}
