package com.m91snik.lesson15.rest.service.impl;

import com.m91snik.lesson15.rest.converter.Converter;
import com.m91snik.lesson15.rest.dto.Expenses;
import com.m91snik.lesson15.rest.entity.ExpensesEntity;
import com.m91snik.lesson15.rest.repository.ExpensesRepository;
import com.m91snik.lesson15.rest.service.ExpensesService;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * Created by m91snik on 10.08.15.
 */
@Service
@Transactional
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public Expenses create(Expenses expenses) {
        ExpensesEntity expensesEntity = Converter.toExpensesEntity(expenses);
        ExpensesEntity savedExpenses = expensesRepository.save(expensesEntity);
        return Converter.toExpenses(savedExpenses);
    }

    @Override
    public Expenses update(Expenses expenses) {
        ExpensesEntity expensesEntity = expensesRepository.findOne(expenses.getId());
        expensesEntity = Converter.toExpensesEntity(expensesEntity, expenses);
        ExpensesEntity savedExpenses = expensesRepository.save(expensesEntity);
        return Converter.toExpenses(savedExpenses);
    }

    @Override
    public List<Expenses> getExpenses(String ownerId, Date from, Date to) {
        List<ExpensesEntity> result;
        if (from == null) {
            if (to == null) {
                to = new Date();
            }
            if (ownerId == null) {
                result = expensesRepository.findAllByCreationTimeLessThan(to);
            } else {
                result = expensesRepository.findAllByOwnerIdAndCreationTimeLessThan(ownerId, to);
            }

        } else {
            if (to == null) {
                to = new Date();
            }
            if (ownerId == null) {
                result = expensesRepository.findAllByCreationTimeBetween(from, to);
            } else {
                result = expensesRepository.findAllByOwnerIdAndCreationTimeBetween(ownerId, from, to);
            }
        }
        List<Expenses> expenses = new ArrayList<>();
        for (ExpensesEntity expensesEntity : result) {
            expenses.add(Converter.toExpenses(expensesEntity));
        }
        return expenses;
    }

    @Override
    public String generateReport(Collection<Expenses> expenses) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(ExpensesServiceImpl.class, "/templates");
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        Template temp = cfg.getTemplate("report.ftl");

        Map<String, Object> model = new HashMap<>();
        model.put("expenses", expenses);

        StringWriter stringWriter = new StringWriter();
        temp.process(model, stringWriter);
        return stringWriter.toString();
    }

    @Override
    public void remove(String expenseId) {
        expensesRepository.delete(expenseId);
    }
}
