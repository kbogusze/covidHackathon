package com.itds.covid.hackathon.covid;

import com.itds.covid.hackathon.covid.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CovidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//code to test connection with DB

//		User person = new User();
//		person.setUsername("bogu");
//		person.setPassword( new BCryptPasswordEncoder().encode("haslo"));
//		repository.insert(person);

		// fetch all customers
//		for (Person customer : repository.findAll()) {
//			System.out.println(customer);
//			System.out.println(customer.getFirstName());
//		}
	}


}
