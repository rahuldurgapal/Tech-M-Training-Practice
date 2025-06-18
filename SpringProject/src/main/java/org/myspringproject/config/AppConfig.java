package org.myspringproject.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.*;

@org.springframework.context.annotation.Configuration
@ComponentScans({
        @ComponentScan("org.myspringproject.service"),
        @ComponentScan("org.myspringproject.repository")
})
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Bean
    public Session session() {
        return sessionFactory().openSession();
    }
}

