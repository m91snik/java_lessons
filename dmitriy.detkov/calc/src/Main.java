import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // создаЄм объект класса Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("¬ведите первый аргумент (целое число): ");
        int value1 = sc.nextInt();

        System.out.print("¬ведите второй аргумент (целое число): ");
        int value2 = sc.nextInt();

        System.out.print("¬ведите символ операции (+ - * /): ");
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
