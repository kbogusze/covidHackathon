package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DealRepository extends MongoRepository<Deal, String> {
}
