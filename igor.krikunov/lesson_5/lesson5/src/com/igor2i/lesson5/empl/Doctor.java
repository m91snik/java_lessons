package com.igor2i.lesson5.empl;

/**
 * Created by igor2i on 28.07.15.
 */
public class Doctor extends Empl{

    private String toolName;

    public int cure(int heal){
        return heal*2;
    }

    @Override
    public int work(int hors) {
        return 0;
    }
}
