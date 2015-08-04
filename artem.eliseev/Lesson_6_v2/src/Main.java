import java.sql.SQLException;

/**
 * Created by Anry on 30.07.2015.
 */
public class Main {
    public static void main(String[] args) {
//        while (true) {
//            try {
//                main(null);
//            } catch (Throwable t) {
//                t.printStackTrace();
//                throw t;
//            }
//        }
        // int i = 0;
        Integer i = null;
        process();


    }

    private static Integer process() {
        Integer i = null;
        while (true) {
            try {
//                System.out.println(10 / i);
                return i++;

            } catch (NullPointerException| ArithmeticException t) {
//                t.printStackTrace();
//                i = 0;
//                return 0;
                return i++;
            }
//            catch (ArithmeticException t) {
//                t.printStackTrace();
//                i = 1;
//            }
            finally {
//                i++;
                return i++;
//            {System.out.println("worked for " +i);}
            }

        }
//        return 0;

    }
}
