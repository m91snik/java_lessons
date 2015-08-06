package lesson5;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public class Engineer extends Employee {

    public Engineer() {
        super("Alex");
    }

    @Override
    protected int workPerDayInternal(int hours) {
        // work hard!!!
        System.out.println("I'm working " + name);
        return hours / 2;
    }
}
