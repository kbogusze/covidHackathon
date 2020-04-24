package com.itds.covid.hackathon.covid.models;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface DocumentRepository extends MongoRepository<Document, String> {


}
