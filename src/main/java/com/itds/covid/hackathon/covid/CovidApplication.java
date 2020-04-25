package com.itds.covid.hackathon.covid;

import com.itds.covid.hackathon.covid.models.DealRepository;
import com.itds.covid.hackathon.covid.models.Person;
import com.itds.covid.hackathon.covid.models.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CovidApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CovidApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//code to test connection with DB

//		Person person = new Person();
//		person.setFirstName("Krzysztof");
//		person.setLastName("Bogu");
//		repository.insert(person);

		// fetch all customers
		for (Person customer : repository.findAll()) {
			System.out.println(customer);
			System.out.println(customer.getFirstName());
		}
	}


}
