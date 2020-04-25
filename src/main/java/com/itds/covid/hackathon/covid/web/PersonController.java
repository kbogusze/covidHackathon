package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Person;
import com.itds.covid.hackathon.covid.models.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	public PersonController() {
		System.out.println("Person Controller instantiated!");
	}

    @Autowired
    private PersonRepository repository;

    @GetMapping("")
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> get(@PathVariable String id) {
        Optional<Person> deal = repository.findById(id);
        if (deal.isPresent()) {
            return new ResponseEntity<>(deal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> add(@RequestBody Person object) {
        Person insertedObject = repository.insert(object);
        return new ResponseEntity<>(insertedObject, HttpStatus.CREATED);
    }
}

