package com.kodlamaiodevs.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlamaiodevs.project.business.responses.GetByIdProgrammingLanguagesResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

    private IProgrammingLanguagesService programmingLanguagesService;

    @Autowired
    public ProgrammingLanguagesController(IProgrammingLanguagesService programmingLanguagesService) {
        this.programmingLanguagesService = programmingLanguagesService;
    }

    @GetMapping()
    public List<GetAllProgrammingLanguagesResponse> getAll(){
        return programmingLanguagesService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguagesResponse getByIdProgrammingLanguagesResponse(@PathVariable int id) {
        return programmingLanguagesService.getByIdProgrammingLanguagesResponse(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateProgrammingLanguageRequest request) {
        this.programmingLanguagesService.add(request);
    }

    @PutMapping
    public void update(@RequestBody UpdateProgrammingLanguageRequest request) {
        this.programmingLanguagesService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.programmingLanguagesService.delete(id);
    }
}
