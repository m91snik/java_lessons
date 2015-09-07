package Utils;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class UserIDImpl implements UserID, Serializable {

    private static String ip;
    private int port;
    private String name;

    public UserIDImpl() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter you login, please: ");
//        this.name = scanner.next();
//        System.out.println("Введите номер порта");
//        String port = scanner.next();
//        if (!port.matches("[0-9]{4}")) {
//            int tmp = (new Random().nextInt()) % 65535;
//            port = ((Integer)( Math.abs(tmp))).toString();
//            System.out.println("Ошибка ввода порта. Присвоен порт номер " + port);
//        }
//        this.port = Integer.valueOf(port);
        this.name = "";
        this.port = Integer.valueOf( ((Integer)( Math.abs((new Random().nextInt()) % 65535))).toString());
        try {
            this.ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Не смогли создать ID юзера");
        }

//        System.out.println("Все готово для начала общения!");
    }

    public UserIDImpl(String ip, int port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserID)) return false;

        UserIDImpl userID = (UserIDImpl) o;

        if (port != userID.port) return false;
        if (ip != null ? !ip.equals(userID.ip) : userID.ip != null) return false;
        return !(name != null ? !name.equals(userID.name) : userID.name != null);

    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + port;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return ip + " " + port + " " + name;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIp() {
        return ip;
    }
}
