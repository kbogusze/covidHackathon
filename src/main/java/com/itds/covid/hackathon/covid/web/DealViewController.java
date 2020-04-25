package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Deal;
import com.itds.covid.hackathon.covid.models.DealRepository;
import com.itds.covid.hackathon.covid.models.Document;
import com.itds.covid.hackathon.covid.models.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DealViewController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DealRepository dealRepository;

    @CrossOrigin
    @GetMapping("/dealview/deals")
    public List<Deal> getAll() {
        return dealRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/dealview/document/deal/{id}")
    public ResponseEntity<Document> getDocumentByDeal(@PathVariable String id) {
        Optional<Document> document = documentRepository.findByDealID(id);
        if (document.isPresent()){
//            document.get().setContent(Base64.getEncoder().encodeToString(document.get().getContent().getData()));
            return new ResponseEntity<>(document.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

}
