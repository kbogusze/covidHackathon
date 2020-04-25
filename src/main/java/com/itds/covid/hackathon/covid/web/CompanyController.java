package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Company;
import com.itds.covid.hackathon.covid.models.CompanyRepository;
import com.itds.covid.hackathon.covid.models.User;
import com.itds.covid.hackathon.covid.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	public CompanyController() {
		System.out.println("Person Controller instantiated!");
	}

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Company> get(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if ( user != null ) {
            Optional<Company> byUserId = repository.findByUserId(user.getId());
            if (byUserId.isPresent()) {
                return new ResponseEntity<>(byUserId.get(), HttpStatus.OK);
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
    public ResponseEntity<Company> getByID(@PathVariable String id) {
        Optional<Company> deal = repository.findById(id);
        if (deal.isPresent()) {
            return new ResponseEntity<>(deal.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Company> add(Principal principal, @RequestBody Company object) {

        User user = userRepository.findByUsername(principal.getName());
        if ( user != null ) {
            object.setUserId(user.getId());
            System.out.println("Person posted: " + object);
            Company insertedObject = repository.insert(object);
            return new ResponseEntity<>(insertedObject, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }
    
}

