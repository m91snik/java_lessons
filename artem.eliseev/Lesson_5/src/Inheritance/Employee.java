package Inheritance;

/**
 * Created by Anry on 28.07.2015.
 */
public abstract class Employee {

    protected String name;

    public abstract int work(int hours);

    public int workPerWeek(int hours) {
        if (hours > 80) {
            throw new IllegalArgumentException("Crazy");
        }
        return workPerWeekInternal(hours) - doLanch();
    }
    public int doLanchInternal() {
        return 1;
    }

    public int doLanch() {
        return 1;
    }

    public abstract int workPerWeekInternal(int hours);


}
