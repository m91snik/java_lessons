package Server;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("context.xml");
        Server server =
                applicationContext.getBean("server", Server.class);
        server.startSession();
    }

}
