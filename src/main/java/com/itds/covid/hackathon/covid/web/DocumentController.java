package com.itds.covid.hackathon.covid.web;

import com.itds.covid.hackathon.covid.models.Document;
import com.itds.covid.hackathon.covid.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService service;

    @GetMapping("/documents/{id}")
    public Document getDocument(@PathVariable String id, Model model) {
        Document document = service.get(id);
        model.addAttribute("title", document.getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(document.getContent().getData()));
        return document;
    }

    @PostMapping("/documents/add")
    public String addDocument(@RequestParam("title") String title,@RequestParam("dealID") String dealID, @RequestParam("content") MultipartFile image) throws IOException {
        String id = service.add(title,dealID, image);
        return "redirect:/photos/" + id;
    }
}
