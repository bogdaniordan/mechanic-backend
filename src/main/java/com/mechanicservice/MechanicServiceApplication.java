package com.mechanicservice;

import com.mechanicservice.data.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class MechanicServiceApplication {

//	//modify later
//	private static void initializeDatabase() {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		DataGenerator dataGenerator = new DataGenerator(entityManager);
//		dataGenerator.populateDb();
//		entityManager.close();
//		entityManagerFactory.close();
//	}

	public static void main(String[] args) {
		SpringApplication.run(MechanicServiceApplication.class, args);
//		initializeDatabase();
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
