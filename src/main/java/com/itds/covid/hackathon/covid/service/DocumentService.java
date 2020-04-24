package com.itds.covid.hackathon.covid.service;

import com.itds.covid.hackathon.covid.models.Document;
import com.itds.covid.hackathon.covid.models.DocumentRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;

    public String add(String title, String dealID, MultipartFile file) throws IOException {
        Document document = new Document();
        document.setDealID(dealID);
        document.setTitle(title);
        document.setContent(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        document = repository.insert(document);
        return document.getId();
    }

    public Document get(String id) {
        return repository.findById(id).get();
    }
}
