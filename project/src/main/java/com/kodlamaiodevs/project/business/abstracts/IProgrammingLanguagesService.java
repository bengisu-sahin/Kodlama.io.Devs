package com.kodlamaiodevs.project.business.abstracts;

import java.util.List;

import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlamaiodevs.project.business.responses.GetByIdProgrammingLanguagesResponse;

public interface IProgrammingLanguagesService {
    public List<GetAllProgrammingLanguagesResponse> getAll();
    public GetByIdProgrammingLanguagesResponse getByIdProgrammingLanguagesResponse(int id);
    public void add(CreateProgrammingLanguageRequest request);
    public void update(UpdateProgrammingLanguageRequest request);
    public void delete(int id);
}
