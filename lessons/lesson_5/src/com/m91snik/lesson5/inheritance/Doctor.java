package com.m91snik.lesson5.inheritance;

/**
 * Created by Valentin on 28.07.2015.
 */
public class Doctor extends Employee {

    private String toolName;

    public Doctor(String name, String toolName) {
        super(name);
        this.toolName = toolName;
    }

    public int cure(int health) {
        return health * 100;
    }

    @Override
    protected int workPerDayInternal(int hours) {
        return hours * 1000;
    }
}
