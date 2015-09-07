package Utils;

/**
 * Created by Ангелина on 06.09.2015.
 */
public class RegisterForm extends MessageImpl {
    private String firstName;
    private String secondName;
    private int age;
    private String nick;
    private String password;

    public RegisterForm() {
        firstName = "";
        secondName = "";
        age = 0;
        password = "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getNickName() {
        return nick;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNick(String nick) {
       this.nick = nick;
    }
//
//    @Override
//    public String toString() {
//        return "RegisterForm{" +
//                "firstName='" + firstName + '\'' +
//                ", secondName='" + secondName + '\'' +
//                ", age=" + age +
//                ", nick='" + nick + '\'' +
//                ", password='" + password + '\'' +
//                ", password='" + super.toString() + '\'' +
//                '}';
//    }
}
