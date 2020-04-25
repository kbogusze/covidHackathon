package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/deals")
public class DealController {

        public DealController() {
            System.out.println("Deal Controller instantiated!");
        }

        @Autowired
        private DealRepository repository;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private PersonRepository personRepository;

        @CrossOrigin
        @GetMapping("")
        public List<Deal> getAll() {
            return repository.findAll();
        }

        @CrossOrigin
        @GetMapping("/{id}")
        public ResponseEntity<Deal> get(@PathVariable String id) {
            Optional<Deal> deal = repository.findById(id);
            if (deal.isPresent()) {
                return new ResponseEntity<>(deal.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }

        @CrossOrigin
        @PostMapping(path = "", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Deal> add(Principal principal, @RequestBody Deal object) {

            User user = userRepository.findByUsername(principal.getName());
            if ( user != null ) {
                Optional<Person> person = personRepository.findByUserId(user.getId());
                if (person.isPresent()) {
                    object.setCustomerId(person.get().getId());
                    System.out.println("Person posted: " + object);
                    Deal insertedObject = repository.insert(object);
                    return new ResponseEntity<>(insertedObject, HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }

        @GetMapping("/customer/{id}")
        public ResponseEntity<?> getDealsByCustomer(@PathVariable String id) {
            List<Deal> deal = repository.findByCustomerId(id);
            if (!CollectionUtils.isEmpty(deal)) {
                return new ResponseEntity<>(deal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }

}
