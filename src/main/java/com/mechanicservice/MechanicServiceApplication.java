package com.mechanicservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
public class MechanicServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(MechanicServiceApplication.class, args);
	}

//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
