package com.kodlamaiodevs.project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
import com.kodlamaiodevs.project.business.core.utilities.mappers.IModelMapperService;
import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.requests.UpdateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlamaiodevs.project.business.responses.GetByIdProgrammingLanguagesResponse;
import com.kodlamaiodevs.project.business.rules.ProgrammingLanguageBusinessRule;
import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import com.kodlamaiodevs.project.entities.ProgrammingLanguage;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class ProgrammingLanguagesManager implements IProgrammingLanguagesService{
    private IProgrammingLanguagesRepository programmingLanguagesRepo;
    private IModelMapperService modelMapperService;
    private ProgrammingLanguageBusinessRule programmingLanguageBusinessRule;

    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {

        List<ProgrammingLanguage> programmingLanguages;
        List<GetAllProgrammingLanguagesResponse> response = new ArrayList<>();
        
        try {
            programmingLanguages = programmingLanguagesRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching programming languages", e);
        }
        
        response = programmingLanguages.stream()
            .map(pl -> modelMapperService.forResponse().map(pl, GetAllProgrammingLanguagesResponse.class))
            .toList();
        
        return response;
    }
    
    @Override
    public void add(CreateProgrammingLanguageRequest request) {

        this.programmingLanguageBusinessRule.checkifPRogrammingLanguageExists(request.getName());
        
        ProgrammingLanguage pl = this.modelMapperService.forRequest().map(request, ProgrammingLanguage.class);
        programmingLanguagesRepo.save(pl);
    }

    @Override
    public GetByIdProgrammingLanguagesResponse getByIdProgrammingLanguagesResponse(int id) {
        ProgrammingLanguage pl = programmingLanguagesRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Programming language not found with id: " + id));
        
        return modelMapperService.forResponse().map(pl, GetByIdProgrammingLanguagesResponse.class);
    }

    @Override
    @Transactional
    public void update(UpdateProgrammingLanguageRequest request) {
        ProgrammingLanguage pl = this.modelMapperService.forRequest().map(request, ProgrammingLanguage.class);
        this.programmingLanguagesRepo.save(pl);
    }

    @Override
    public void delete(int id) {
        programmingLanguagesRepo.deleteById(id);
    }
    
}
