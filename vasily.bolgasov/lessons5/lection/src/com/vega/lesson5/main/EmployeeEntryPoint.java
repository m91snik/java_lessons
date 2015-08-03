package com.vega.lesson5.main;

import com.vega.lesson5.main.inheritance.Doctor;
import com.vega.lesson5.main.inheritance.Employee;
import com.vega.lesson5.main.inheritance.Engineer;

/**
 * Created by Veg'Zul on 28.07.2015.
 */
public class EmployeeEntryPoint {
    public static void main(String[] args) {
        Employee employee;
        if("d".equals(args[0])){
            employee = new Doctor("Who","ScrewDriver");
        }else{
            employee = new Engineer("Bob");
        }

//       Employee employee = new Engineer("Bob");
//       System.out.println(employee);
        System.out.println(employee.workPerWeek(20));

    }
}
