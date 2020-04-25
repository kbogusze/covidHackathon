package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Document;
import com.itds.covid.hackathon.covid.models.DocumentRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    @GetMapping("/documents/{id}")
    public Document getDocument(@PathVariable String id, Model model) {
        return repository.findById(id).get();
    }

    @PostMapping("/documents/add")
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
