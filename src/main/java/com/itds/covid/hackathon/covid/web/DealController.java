package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
        private CompanyRepository personRepository;

        @Autowired
        private DocumentRepository documentRepository;

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
        public ResponseEntity<?> add(Principal principal, @RequestBody Deal object) {
            if (StringUtils.isEmpty(object.getCollateralTitle()))
            {
                return new ResponseEntity<>("Title can not be null", HttpStatus.BAD_REQUEST);
            }
            if (StringUtils.isEmpty(object.getRequestDescription()))
            {
                return new ResponseEntity<>("Description must be filled", HttpStatus.BAD_REQUEST);
            }
//            Integer random = (int)(Math.random() * ((100 - 1) + 1)) + 1;
//            object.setCollectedValue(random);
            object.setCollectedValue(0);
            User user = userRepository.findByUsername(principal.getName());
            if ( user != null ) {
                    object.setUserId(user.getId());
                    System.out.println("Person posted: " + object);
                    Deal insertedObject = repository.insert(object);

                    if (!StringUtils.isEmpty(object.getMainPictureId())){
                        Optional<Document> byId = documentRepository.findById(object.getMainPictureId());
                        if (byId.isPresent()){
                            byId.get().setDealID(insertedObject.getId());
                            documentRepository.save(byId.get());
                            insertedObject.setMainPictureName(byId.get().getTitle());
                            repository.save(object);
                        }
                    }

                    return new ResponseEntity<>(insertedObject, HttpStatus.CREATED);

            } else {
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }

        @GetMapping("/customer/{id}")
        public ResponseEntity<?> getDealsByCustomer(@PathVariable String id) {
            List<Deal> deal = repository.findByUserId(id);
            if (!CollectionUtils.isEmpty(deal)) {
                return new ResponseEntity<>(deal, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }

}
