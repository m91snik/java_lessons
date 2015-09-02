package com.m91snik.lesson15.rest.repository.impl;

import com.m91snik.lesson15.rest.dto.Expenses;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * Created by m91snik on 14.08.15.
 */
public class ReportShowTest {

    @Test
    public void generateReportTest() throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(ReportShowTest.class, "/templates");
        cfg.setObjectWrapper(new DefaultObjectWrapper());
        Template temp = cfg.getTemplate("report.ftl");

        Expenses expenses=new Expenses();
        expenses.setAmount(100);
        expenses.setCurrency("rub");
        expenses.setComment("comment");
        expenses.setDescription("descr");
        expenses.setCreationTime("10.08.2015 10:30");

        Map<String,Object> model=new HashMap<>();
        List<Expenses> expenseses=new ArrayList<>();
        expenseses.add(expenses);
        model.put("expenses", expenseses);

        StringWriter stringWriter = new StringWriter();
        temp.process(model, stringWriter);
        System.out.println(stringWriter.toString());
    }
}
