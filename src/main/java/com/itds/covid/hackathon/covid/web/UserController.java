package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.User;
import com.itds.covid.hackathon.covid.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @CrossOrigin
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> add(@RequestBody User object) {
        if (StringUtils.isEmpty(object.getPassword()))
        {
            return new ResponseEntity<>("Password must be filled", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(object.getUsername()))
        {
            return new ResponseEntity<>("Username must be filled", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(object.getEmail()))
        {
            return new ResponseEntity<>("Email must be filled", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(object.getFirstName()))
        {
            return new ResponseEntity<>("First name must be filled", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(object.getLastName()))
        {
            return new ResponseEntity<>("Last name must be filled", HttpStatus.BAD_REQUEST);
        }


        if (repository.findByUsername(object.getUsername()) == null) {
            object.setPassword(new BCryptPasswordEncoder().encode(object.getPassword()));
            User insertedObject = repository.save(object);
            return new ResponseEntity<>("", HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<>("Username exist", HttpStatus.CONFLICT);
        }
    }



}
