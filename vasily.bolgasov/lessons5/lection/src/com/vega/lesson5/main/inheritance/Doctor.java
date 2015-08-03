package com.vega.lesson5.main.inheritance;

/**
 * Created by Veg'Zul on 28.07.2015.
 */
public class Doctor extends Employee {

    private String toolName;

    public Doctor(String name,String toolName) {
//        super(name);
        this.toolName = toolName;
    }

    public int cure(int health){
        return health*100;
    }

    @Override
    public int doLaunch() {
        return 0;
    }

    @Override
    protected int workPerDayInternal(int hours) {
        return 80;
    }
}
