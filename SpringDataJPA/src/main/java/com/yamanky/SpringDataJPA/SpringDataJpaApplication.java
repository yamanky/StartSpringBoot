package com.yamanky.SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yamanky.SpringDataJPA.entity.Customer;
import com.yamanky.SpringDataJPA.repository.CustomerRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... strings) {
		Customer customer = new Customer();
		customer.setFirstName("Hidetoshi");
		customer.setLastName("Dekisugi");
		customerRepository.save(customer);
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		System.out.println("*********");
		customerRepository.findByOrderByFirstName().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
}
