package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DocumentRepository extends MongoRepository<Document, String> {

    List<Document> findByDealID(String dealID);
}
