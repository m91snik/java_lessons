package Server.javaBasedSpring;

import Server.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Ангелина on 06.09.2015.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
        Server server = applicationContext.getBean(Server.class);
        server.startSession();
    }
}
