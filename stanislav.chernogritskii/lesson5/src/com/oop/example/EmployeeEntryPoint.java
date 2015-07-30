package com.oop.example;

import com.oop.example.inheritance.Doctor;
import com.oop.example.inheritance.Employee;
import com.oop.example.inheritance.Engineer;

/**
 * Created by stanislav on 28.07.15.
 */
public class EmployeeEntryPoint {

    public static void main(String[] args) {
        Employee employee;
        if("d".equals(args[0])) {
            employee = new Doctor("Who", "ScrewDriver");
        } else {
            employee = new Engineer("Stas");
        }

        System.out.println(employee.workPerDay(20));
    }
}
