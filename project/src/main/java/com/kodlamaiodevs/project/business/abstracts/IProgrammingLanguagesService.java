package com.kodlamaiodevs.project.business.abstracts;

import java.util.List;

import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;

public interface IProgrammingLanguagesService {
    public List<GetAllProgrammingLanguagesResponse> getAll();
    public void add(CreateProgrammingLanguageRequest request);
}
