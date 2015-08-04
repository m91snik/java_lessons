package lesson5;

/**
 * Created by kamyshov.sergey on 28.07.15.
 */
public class Main {
    public static void main(String[] args) {
        Employee engineer = new Engineer();
        Employee doctor = new Doctor("Who", "ScrewDriver");
        doctor.workPerDay(1000);
        engineer.workPerDay(20);

    }
}
