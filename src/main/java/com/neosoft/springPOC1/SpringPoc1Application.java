package com.neosoft.springPOC1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@SpringBootApplication
public class SpringPoc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringPoc1Application.class, args);
	}

}
