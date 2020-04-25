package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.User;
import com.itds.covid.hackathon.covid.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @CrossOrigin
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> add(@RequestBody User object) {
        object.setPassword( new BCryptPasswordEncoder().encode(object.getPassword()));
        User insertedObject = repository.insert(object);
        return new ResponseEntity<>("", HttpStatus.CREATED);
    }

}
