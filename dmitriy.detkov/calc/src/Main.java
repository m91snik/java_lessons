import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ������ ������ ������ Scanner
        Scanner sc = new Scanner(System.in);

        System.out.print("������� ������ �������� (����� �����): ");
        int value1 = sc.nextInt();

        System.out.print("������� ������ �������� (����� �����): ");
        int value2 = sc.nextInt();

        System.out.print("������� ������ �������� (+ - * /): ");
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
