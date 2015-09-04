package com.lexsus.chat.spring.java;

import com.lexsus.chat.ServerMessageSystem;
import com.lexsus.chat.SharedMap;
import com.lexsus.chat.SharedQueue;
import com.lexsus.chat.base.LaggedUserService;
import com.lexsus.chat.consumer.Consumer;
import com.lexsus.chat.consumer.ServerConsumer;
import com.lexsus.chat.generator.MessageGenerator;
import com.lexsus.chat.generator.ServerMessageGenerator;
import com.lexsus.chat.processor.MessageProcessor;
import com.lexsus.chat.processor.ServerMessageProcessor;
import com.lexsus.chat.producer.Producer;
import com.lexsus.chat.producer.ServerProducer;
import com.lexsus.chat.saver.FileMessageSaver;
import com.lexsus.chat.saver.MessageSaver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by Lexsus on 30.08.2015.
 */
@Configuration
@ComponentScan("com.m91snik.lesson13")
public class ConfigServer {
    //
//    @Autowired
//    SharedQueue<String> queue;

    @Bean
    public MessageSaver<Message> saver(){return  new FileMessageSaver();}
    @Bean
    public SharedQueue<Message> queue(){
        return new SharedQueue<>();
    }

    @Bean
    public SharedMap<String,ClientInfo> map(){
        return new SharedMap<>();
    }

    @Bean
    public Consumer<Message> consumer() {
        return new ServerConsumer<>(queue(), processor());
    }

    @Bean
    public Producer<Message> producer() {
        return new ServerProducer<>(queue(), generator());
    }

    @Bean
    public MessageGenerator<Message> generator() {
        return new ServerMessageGenerator(saver());
    }

    @Bean
    public MessageProcessor<Message> processor() {
        return new ServerMessageProcessor(map());
    }

    @Bean
    public ServerMessageSystem serverSystem() { return new ServerMessageSystem(consumer(), producer());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        //TODO
        em.setPackagesToScan(new String[] { "com.lexsus.chat.entity" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //TODO
        dataSource.setUrl("jdbc:mysql://localhost:3306/lesson14_jdbc");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
        dataSource.setUsername("root");
        dataSource.setPassword("Uksus1980");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    @Bean
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}

