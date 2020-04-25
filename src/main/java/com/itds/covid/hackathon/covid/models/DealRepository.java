package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "deals", path = "deals")
public interface DealRepository extends MongoRepository<Deal, String> {

    List<Deal> findByCustomerId(String customerId);
}
