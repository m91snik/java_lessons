

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner vvod = new Scanner(System.in);

        Operation operation = new Operation();

        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();


        System.out.println("Operation: plus, minus, muliply, transpose.");
        String vvodtext = vvod.next();


        Znack oper = Znack.valueOf(vvodtext);


        switch (oper) {
            case plus : operation.plus(matrix1,matrix2); break;

            case minus : operation.substraction(matrix1, matrix2); break;

            case multiply: operation.multiply(matrix1, matrix2); break;

            case transpose : operation.transpose(matrix1); break;

            default: System.out.println("Vveli neverni znak.");


        }
    }
}
