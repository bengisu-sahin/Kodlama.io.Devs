package com.kodlamaiodevs.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
import com.kodlamaiodevs.project.entities.ProgrammingLanguage;


@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

    private IProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    public ProgrammingLanguagesController(IProgrammingLanguagesService programmingLanguagesService) {
        this.programmingLanguagesService = programmingLanguagesService;
    }

    @GetMapping("/getAll")
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguagesService.getAll();
    }
}
