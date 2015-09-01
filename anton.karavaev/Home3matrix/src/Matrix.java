import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by HP on 29.07.2015.
 */
import java.io.BufferedReader;

public class Matrix {

    public int stroka;
    public int stolbec;
    int [][]  mas = new int[stroka][stolbec];

    public Matrix () {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        boolean a;
        do { a = false;
            try {

                System.out.println("Vvedite kolichestvo strok matrici: ");
                String str = null;
                str = reader.readLine();
                stroka = Integer.parseInt(str);
            } catch (IOException | NumberFormatException e) {
                System.out.println("method .In is mistake");
               e.printStackTrace();
                a = true;

            }
        } while (a);





        System.out.println("Vvedite kolichestvo stolbcov matrici: ");
        String sto = null;
        try {
            sto = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stolbec = Integer.parseInt(sto);




        mas = new int[stroka][stolbec];
        Scanner in = new Scanner(System.in);


        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                print("Enter the elements of array mas1 [" + i + "][" + j + "]:");
                mas[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                print(mas[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void print (String str) {
        System.out.print(str);
    }

}


