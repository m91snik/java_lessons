import com.lexsus.client.Client;


/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class ClientChat {
    static int server_port;
    static int client_port;
    static String ip_address;


    public static void main(String[] args) {

        server_port = Integer.parseInt(args[1]);
        client_port = Integer.parseInt(args[2]);
        ip_address = args[0];
        new Client(server_port,client_port,ip_address).start();
    }
}