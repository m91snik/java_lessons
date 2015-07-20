import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first argument (integer): ");
        int value1 = sc.nextInt();

        System.out.print("Enter the first argument (integer): ");
        int value2 = sc.nextInt();

        System.out.print("Enter operation symbol (+ - * /): ");
        char operator = sc.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.print(value1 + value2);
                break;
            case '-':
                System.out.print(value1 - value2);
                break;
            case '*':
                System.out.print(value1 * value2);
                break;
            case '/':
                System.out.print(value1 / value2);
                break;
        }
    }
}
