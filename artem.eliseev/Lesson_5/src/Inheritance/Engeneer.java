package Inheritance;

/**
 * Created by Anry on 28.07.2015.
 */
public class Engeneer extends Employee {
    //constructor
//    public Engeneer (String name) {
//        super (name);
//    }


    @Override
    protected int workPerDayInternal(int hours) {
        return hours / 2;

    }

    @Override
    protected int doLanch ();


}
