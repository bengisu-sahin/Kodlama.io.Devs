package com.kodlamaiodevs.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaiodevs.project.business.abstracts.ILanguageTechonologyService;
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
    public List<LanguageTechnology>  getAll() {
        return languageTechonologyService.getAll();
    }

    @GetMapping("/getByProgrammingLanguageName")
    public List<LanguageTechnology> getByProgrammingLanguageName(@RequestParam int id) {
        return languageTechonologyService.getByLanguageName(id);
    }
    
}
