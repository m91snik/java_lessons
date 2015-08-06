/**
 * Created by User on 30.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        int i = 0;
        try {
            System.out.print(10 / i);
        } catch (Exception t) {
            t.printStackTrace();
            i = 1;
        }
    }
}
