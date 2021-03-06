package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DealRepository extends MongoRepository<Deal, String> {

    List<Deal> findByUserId(String userId);
}
