import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by HP on 25.07.2015.
 */
public class MatrixCalculator {
    public static void main(String[] args) throws Exception {


        Scanner in = new Scanner(System.in);

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Working with massiv 1");
        System.out.println("enter the string");
        String str1 = reader.readLine();
        int ch1 = Integer.parseInt(str1);

        System.out.println("enter the column");
        String str2 = reader.readLine();
        int ch2 = Integer.parseInt(str2);

        int [][] mas1 = new int [ch1][ch2];

        for (int i = 0; i < ch1; i++) {
            for (int j = 0; j < ch2; j++) {
                System.out.print("Enter the elements of array mas1 [" + i + "][" + j + "]:");
                mas1[i][j] = in.nextInt();
            }
        }



        for (int i = 0; i < ch1; i++) {
            for (int j = 0; j < ch2; j++) {
                System.out.print(mas1[i][j] + "\t");
            }
            System.out.println();
        }



        System.out.println("Working with massiv 2");
        System.out.println("Addition of matrices if they are the same size.");

        System.out.println("enter the length of the string");
        String str3 = reader.readLine();
        int ch3 = Integer.parseInt(str3);

        System.out.println("enter the length of the column");
        String str4 = reader.readLine();
        int ch4 = Integer.parseInt(str4);

        int [][] mas2 = new int [ch3][ch4];



        for (int i = 0; i < ch3; i++) {
            for (int j = 0; j < ch4; j++) {
                System.out.print("Enter the elements of array mas2 [" + i + "][" + j + "]:");
                mas2[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < ch3; i++) {
            for (int j = 0; j < ch4; j++) {
                System.out.print(mas2[i][j] + "\t");
            }
            System.out.println();
        }




//        int [][] addmas  = new int [ch1][ch2];
//
//        if (ch1 == ch3 && ch2==ch4) {
//            System.out.println("Add the two matrices");
//            for (int i = 0; i < ch1; i++) {
//                for (int j = 0; j < ch2; j++) {
//                    addmas[i][j] = mas1[i][j] + mas2[i][j];
//
//                    System.out.print(addmas[i][j] + "\t");
//                }
//
//                System.out.println();
//
//
//            }
//        } else {System.out.println("you cannot add matrices of different dimensions");}
//
//
//
//        int [][] subsractmas  = new int [ch1][ch2];
//
//        if (ch1 == ch3 && ch2==ch4) {
//            System.out.println("Substract the two matrices");
//            for (int i = 0; i < ch1; i++) {
//                for (int j = 0; j < ch2; j++) {
//                    subsractmas[i][j] = mas1[i][j] + (-1) * mas2[i][j];
//
//                    System.out.print(subsractmas[i][j] + "\t");
//                }
//
//                System.out.println();
//
//
//            }
//
//        } else { System.out.println("you cannot substract matrices of different dimensions");}
//


        int [][] multiplymas  = new int [ch1][ch4];
        if (ch2 == ch3 ) {

            System.out.println("Multiply the two matrices");
            for (int f = 0; f < ch4 ; f++) {
                for (int j = 0; j <ch1 ; j++) {
                    for (int i = 0; i <ch3 ; i++) {
                        multiplymas[j][f] = multiplymas[j][f] + mas1[j][i]*mas2[i][f];

                    }

                }

            }
        } else {
            System.out.println("you cannot multiply matrices. the number of columns " +
                    "of 1st matrix is not equal to the number of rows of 2nd matrix.");
        }

        for (int j = 0; j <ch1; j++) {
            for (int f = 0; f <ch4 ; f++) {
                System.out.print(multiplymas[j][f] + "\t");
            }
            System.out.println();
        }
    }

}

