package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Person;
import com.itds.covid.hackathon.covid.models.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	public PersonController() {
		System.out.println("Person Controller instantiated!");
	}

    @Autowired
    private PersonRepository repository;

    @GetMapping("/{id}")
    public List<Person> getAllPersons(@PathVariable String id) {
        return repository.findAll();
    }
}

