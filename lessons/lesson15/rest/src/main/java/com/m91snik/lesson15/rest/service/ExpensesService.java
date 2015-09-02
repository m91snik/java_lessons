package com.m91snik.lesson15.rest.service;

import com.m91snik.lesson15.rest.dto.Expenses;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ExpensesService {

    Expenses create(Expenses expenses);

    Expenses update(Expenses expenses);

    List<Expenses> getExpenses(String ownerId, Date from, Date to);

    String generateReport(Collection<Expenses> expenses) throws IOException, TemplateException;

    void remove(String expenseId);
}
