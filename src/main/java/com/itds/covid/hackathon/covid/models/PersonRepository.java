package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

//@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends MongoRepository<Person, String> {



}
