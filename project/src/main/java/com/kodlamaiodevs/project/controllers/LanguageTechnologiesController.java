package com.kodlamaiodevs.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaiodevs.project.business.abstracts.ILanguageTechonologyService;
import com.kodlamaiodevs.project.business.requests.CreateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.requests.DeleteLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.requests.UpdateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.responses.GetAllLanguageTechnologyResponse;
import com.kodlamaiodevs.project.entities.LanguageTechnology;

@RestController
@RequestMapping("/api/languagetechonologies")
public class LanguageTechnologiesController {
    private final ILanguageTechonologyService languageTechonologyService;

    @Autowired
    public LanguageTechnologiesController(ILanguageTechonologyService languageTechonologyService) {
        this.languageTechonologyService = languageTechonologyService;
    }

    @GetMapping("/getAll")
    public List<GetAllLanguageTechnologyResponse>  getAll() {
        return languageTechonologyService.getAll();
    }

    @GetMapping("/getByProgrammingLanguageName")
    public List<LanguageTechnology> getByProgrammingLanguageName(@RequestParam int id) {
        return languageTechonologyService.getByLanguageName(id);
    }
    
    @PostMapping("/add")
    public void add(@RequestBody CreateLanguageTechnologyRequest request) {
        languageTechonologyService.add(request);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody DeleteLanguageTechnologyRequest request) {
        languageTechonologyService.delete(request);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateLanguageTechnologyRequest request) {
        languageTechonologyService.update(request);
    }
}
