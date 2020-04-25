package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Person;
import com.itds.covid.hackathon.covid.models.PersonRepository;
import com.itds.covid.hackathon.covid.models.User;
import com.itds.covid.hackathon.covid.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	public PersonController() {
		System.out.println("Person Controller instantiated!");
	}

    @Autowired
    private PersonRepository repository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Person> get(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if ( user != null ) {
            Person byUserId = repository.findByUserId(user.getId());
            if (byUserId != null ) {
                return new ResponseEntity<>(byUserId, HttpStatus.OK);
            } else
            {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Person> getByID(@PathVariable String id) {
        Optional<Person> deal = repository.findById(id);
        if (deal.isPresent()) {
            return new ResponseEntity<>(deal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> add(Principal principal, @RequestBody Person object) {

        User user = userRepository.findByUsername(principal.getName());
        if ( user != null ) {
            object.setUserId(user.getId());
            System.out.println("Person posted: " + object);
            Person insertedObject = repository.insert(object);
            return new ResponseEntity<>(insertedObject, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
    
}

