package com.m91snik.lesson5;

import com.m91snik.lesson5.inheritance.Doctor;
import com.m91snik.lesson5.inheritance.Employee;
import com.m91snik.lesson5.inheritance.Engineer;

/**
 * Created by Valentin on 28.07.2015.
 */
public class EmployeeEntryPoint {

    public static void main(String[] args) {
        Employee employee;
        if ("d".equals(args[0])) {
            employee = new Doctor("Who", "ScrewDriver");
        } else {
            employee = new Engineer("Bob");
        }

        System.out.println(employee.workPerDay(20));
        //System.out.print(employee.workPerDay(16));
    }
}
