package edu.mum.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeShopApplication {

	public static void main(String[] args) {
		System.out.println("This is a test");
		SpringApplication.run(CoffeShopApplication.class, args);
	}    
}