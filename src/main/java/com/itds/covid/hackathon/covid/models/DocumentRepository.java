package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface DocumentRepository extends MongoRepository<Document, String> {

    Optional<Document> findByDealID(String dealID);
}
