package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
public class DealViewController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/dealview/deals")
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

//    @CrossOrigin
//    @GetMapping("/dealview/document/deal/{id}")
//    public ResponseEntity<List<Document>> getDocumentByDeal(@PathVariable String id) {
//        List<Document> document = documentRepository.findByDealID(id);
//        if (document != null){
////            document.get().setContent(Base64.getEncoder().encodeToString(document.get().getContent().getData()));
//            return new ResponseEntity<>(document, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
//        }
//    }


    @CrossOrigin
    @GetMapping("/dealview/mainpicture/{id}")
    public ResponseEntity<Document> getMainPicture(@PathVariable String id) {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()){
//            document.get().setContent(Base64.getEncoder().encodeToString(document.get().getContent().getData()));
            return new ResponseEntity<>(document.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @RequestMapping(value ="/dealview/mainpicture/stream/{id}/{imagename}"  ,
            produces = {"image/png", "image/jpeg"},
            method = RequestMethod.GET
    )
    public @ResponseBody byte[] getImage(@PathVariable String id , @PathVariable String imagename) throws IOException {
        Optional<Document> document = documentRepository.findById(id);
        if (document.isPresent()){
//            byte[] byteArray = Base64.getEncoder().encode(document.get().getContent().getData());
            InputStream in = new ByteArrayInputStream(document.get().getContent().getData());
            return IOUtils.toByteArray(in);
        } else {
            return null;
        }

    }

    @CrossOrigin
    @GetMapping("/dealview/details/{id}")
    public ResponseEntity<DealDetailProxy> getDealDetails(@PathVariable String id) {

        DealDetailProxy dealDetailProxy = new DealDetailProxy();
        Optional<Deal> byId = dealRepository.findById(id);

        if (byId.isPresent()){
            dealDetailProxy.setDeal(byId.get());
            String userId = byId.get().getUserId();
            Optional<User> byId1 = userRepository.findById(userId);
            if (byId1.isPresent()){
                byId1.get().setPassword(null);
                byId1.get().setUsername(null);
                byId1.get().setId(null);
                byId1.get().setCardIdNumber(null);
                dealDetailProxy.setUser(byId1.get());

                Optional<Company> byUserId = companyRepository.findByUserId(userId);
                byUserId.get().setUserId(null);
                dealDetailProxy.setCompany(byUserId.get());
            }


            return new ResponseEntity<>(dealDetailProxy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
