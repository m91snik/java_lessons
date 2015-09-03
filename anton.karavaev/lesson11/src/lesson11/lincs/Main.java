package lesson11.lincs;

/**
 * Created by HP on 20.08.2015.
 */
public class Main {

    private static int increment (int i) {return i;}
    public static void main(String[] args) {
        {Main:: increment}
    }
}
