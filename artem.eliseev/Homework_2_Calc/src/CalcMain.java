/**
 * Created by Anry on 21.07.2015.
 */
import java.util.Scanner;
import java.io.*;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
public class CalcMain {
    public static void main(String... args) {
        PrintStream printStream = new PrintStream(System.out, true, "cp866");
        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in, "Cp866"));

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp866"), true);


            System.out.println("Привет, это калькулятор, я умею складывать, вычитать, умножать и делить 2 целых числа. " +
                    "\nВведите первое число");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            System.out.println("Введите второе число");
            int y = in.nextInt();
//            char operation = in.nextChar();
//            if (operation.equals("+"))

                System.out.println(x + y);

    }
        catch(Exception e) {
            System.out.println();
        }
    }
}

