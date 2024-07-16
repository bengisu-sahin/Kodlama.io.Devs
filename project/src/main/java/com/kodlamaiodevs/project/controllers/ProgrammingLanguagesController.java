package com.kodlamaiodevs.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;


@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

    private IProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    public ProgrammingLanguagesController(IProgrammingLanguagesService programmingLanguagesService) {
        this.programmingLanguagesService = programmingLanguagesService;
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguagesResponse> getAll(){
        return programmingLanguagesService.getAll();
    }

@PostMapping("/add")
public void add(@RequestBody CreateProgrammingLanguageRequest request) {
    System.out.println(request.getName());
    this.programmingLanguagesService.add(request);
}

}
