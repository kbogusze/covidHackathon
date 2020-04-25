package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {

    public Person findByUserId(String id);
}
