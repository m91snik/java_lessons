package Utils;

import java.util.Scanner;

/**
 * Created by root on 9/7/15.
 */
public class FormFactory {
    public static MessageImpl createRegForm() {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setType(MessageType.REGISTER);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter you name, please: ");
        registerForm.setFirstName(scanner.next());

        System.out.println("Enter you surname, please: ");
        registerForm.setSecondName(scanner.next());

        System.out.println("Enter you age, please: ");
        registerForm.setAge(Integer.valueOf(scanner.next()));

        System.out.println("Enter you nickname, please: ");
        registerForm.setNick(scanner.next());

        System.out.println("Enter you password, please: ");
        registerForm.setPassword(scanner.next());

        System.out.println("Register form OK");
        return registerForm;
    }

    public static MessageImpl createLoginForm() {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setType(MessageType.LOGIN);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter you nickname, please: ");
        String str = scanner.nextLine();
        registerForm.setNick(str);

        System.out.println("Enter you password, please: ");
        registerForm.setPassword(scanner.next());

        return registerForm;
    }
}
