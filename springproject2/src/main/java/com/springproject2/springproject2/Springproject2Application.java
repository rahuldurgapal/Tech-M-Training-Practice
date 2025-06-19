package com.springproject2.springproject2;

import com.springproject2.springproject2.runner.DataLoader;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springproject2Application {

	@Bean
	public SessionFactory sessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Springproject2Application.class, args);
		DataLoader loader = context.getBean(DataLoader.class);
		loader.run();
	}

}
