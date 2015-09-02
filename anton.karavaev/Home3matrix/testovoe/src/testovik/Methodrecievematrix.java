package testovik;

import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by HP on 17.08.2015.
 */
public class Methodrecievematrix {

    public Methodrecievematrix () {}
    public int[][] array;


    public int [][] Getarray () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("vvedite kol-vo strok: ");
        String str1 = scanner.next();
        int kolstrok = Integer.parseInt(str1);

        System.out.println();

        System.out.print("vvedite kol-vo stolbcov: ");
        String str2 = scanner.next();
        int kolkolonok = Integer.parseInt(str2);

        int [] [] array = new int[kolstrok][kolkolonok];


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(("Enter the elements of array mas1 [" + i + "][" + j + "]:"));
                array[i][j] = scanner.nextInt();
            }
        }
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                System.out.print((array[i][j] + "\t"));
//            }
//            System.out.println();
//        }
        return array;
    }

   public void vivod (int [] [] a) {
       for (int [] row : a) {
           System.out.println(Arrays.toString(row));
       }
   }
}
