package com.kodlamaiodevs.project.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.ILanguageTechonologyService;
import com.kodlamaiodevs.project.business.core.utilities.mappers.IModelMapperService;
import com.kodlamaiodevs.project.business.requests.CreateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.requests.DeleteLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.requests.UpdateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.business.responses.GetAllLanguageTechnologyResponse;
import com.kodlamaiodevs.project.dataAccess.abstracts.ILanguageTechnologyRepository;
import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import com.kodlamaiodevs.project.entities.LanguageTechnology;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageTechnologiesManager implements ILanguageTechonologyService {

    private ILanguageTechnologyRepository languageTechnologyRepo;
    private IProgrammingLanguagesRepository programmingLanguagesRepo;
    private IModelMapperService modelMapperService;

    @Override
    public List<GetAllLanguageTechnologyResponse> getAll() {
        List<GetAllLanguageTechnologyResponse> response = languageTechnologyRepo.findAll().stream()
                .map(lt -> modelMapperService.forResponse().map(lt, GetAllLanguageTechnologyResponse.class)).toList();
        return response;
    }

    @Override
    public List<LanguageTechnology> getByLanguageName(int id) {
        List<LanguageTechnology> languageTechnologies = languageTechnologyRepo.findAll();
        List<LanguageTechnology> result = new ArrayList<>();
        for (LanguageTechnology languageTechnology : languageTechnologies) {
            if (languageTechnology.getProgrammingLanguage().getId() == id ) {
                result.add(languageTechnology);
            }
        }
        return result;
    }

    @Override
    @Transactional 
    public void add(CreateLanguageTechnologyRequest request) {
        LanguageTechnology languageTechnology = this.modelMapperService.forRequest().map(request, LanguageTechnology.class);
        //languageTechnology.setId(0);
        languageTechnologyRepo.save(languageTechnology);
        
    }
    

    @Override
    public void delete(DeleteLanguageTechnologyRequest request) {
        LanguageTechnology languageTechnology = languageTechnologyRepo.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Language technology not found."));
        languageTechnologyRepo.delete(languageTechnology);
    }

    @Override
    public void update(UpdateLanguageTechnologyRequest request) {
        LanguageTechnology languageTechnology = languageTechnologyRepo.getById(request.getId());
        if (languageTechnology == null) {
            throw new RuntimeException("Language technology not found.");
        }
        System.out.println(languageTechnology.getName());
        languageTechnology.setName(request.getName());
        languageTechnologyRepo.save(languageTechnology);
        System.out.println(languageTechnology.getName());

    }
}
