package lesson5;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public abstract class Employee {

    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public int workPerDay(int hourse) {
        if (hourse > 80) {
            throw new IllegalArgumentException("You are crazy");
        }
        return workPerDayInternal(hourse) - doLaunch();
    }

    public final int doLaunch() { // final - чтобы нельзя было переопределить public метод в наследнике
        return 1;
    }

    protected abstract int workPerDayInternal(int hours);
}
