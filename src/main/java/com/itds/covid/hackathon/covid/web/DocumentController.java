package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Document;
import com.itds.covid.hackathon.covid.models.DocumentRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@RestController
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    public DocumentController() {
        System.out.println("Document Controller instantiated!");
    }

    @CrossOrigin
    @GetMapping("/documents/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable String id) {
        Optional<Document> document = repository.findById(id);
        if (document.isPresent()){
//            document.get().setContent(Base64.getEncoder().encodeToString(document.get().getContent().getData()));
            return new ResponseEntity<>(document.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @PostMapping("/documents")
    public String addDocument(@RequestParam("title") String title,@RequestParam("dealID") String dealID, @RequestParam("content") MultipartFile file) throws IOException {
        Document document = new Document();
        document.setDealID(dealID);
        document.setTitle(title);
        document.setContent(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        document = repository.insert(document);

        return document.getId();
    }
}
