import com.lexsus.client.Server;

import java.util.Scanner;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class ServerChat
{
    static int server_port;
    static int client_port;

    public static void main(String[] args)
    {
        server_port = Integer.parseInt(args[0]);
        client_port = Integer.parseInt(args[1]);

        Server server = new Server(server_port,client_port);
        server.start();

        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        while (!"exit".equals(text)) {
            text = scanner.next();
        }
        server.stop();
        System.out.println("Good bye!");
    }
}
