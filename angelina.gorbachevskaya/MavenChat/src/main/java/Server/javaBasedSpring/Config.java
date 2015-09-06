package Server.javaBasedSpring;

import Server.Consumer.Consumer;
import Server.Consumer.ServerConsumer;
import Server.MessageReceiver.MessageReceiver;
import Server.MessageReceiver.ServerReceiver;
import Server.MessageSender.MessageSender;
import Server.MessageSender.ServerSender;
import Server.Producer.Producer;
import Server.Producer.ServerProducer;
import Server.Server;
import Server.SharedQueue;
import Utils.MessageImpl;
import Utils.UserIDImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import Server.SharedConnectionsDatabase;

/**
 * Created by Ангелина on 06.09.2015.
 */
@Configuration
@ComponentScan("Server")
public class Config {
    //
//    @Autowired
//    SharedQueue<String> queue;

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SharedQueue<MessageImpl> queue() {
        return new SharedQueue<MessageImpl>();
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public SharedConnectionsDatabase<UserIDImpl> connections() {
        return new SharedConnectionsDatabase<UserIDImpl>();
    }


    @Bean
    public Consumer<MessageImpl, UserIDImpl> consumer() {
        return new ServerConsumer<>(queue(), sender());
    }

    @Bean
    public Producer<MessageImpl, UserIDImpl> producer() {
        return new ServerProducer<>(queue(), receiver());
    }

    @Bean
    public MessageSender<MessageImpl, UserIDImpl> sender() {
        return new ServerSender(connections(), new UserIDImpl("localhost", 1992, "server"));
    }

    @Bean
    public MessageReceiver<MessageImpl, UserIDImpl> receiver() {
        return new ServerReceiver(connections(), new UserIDImpl("localhost", 1992, "server"));
    }

    @Bean
    public Server server() {
        return new Server(producer(), consumer());
    }
}

