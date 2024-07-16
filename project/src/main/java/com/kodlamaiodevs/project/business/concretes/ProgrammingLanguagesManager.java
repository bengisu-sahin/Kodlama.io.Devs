package com.kodlamaiodevs.project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
import com.kodlamaiodevs.project.business.requests.CreateProgrammingLanguageRequest;
import com.kodlamaiodevs.project.business.responses.GetAllProgrammingLanguagesResponse;
import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import com.kodlamaiodevs.project.entities.ProgrammingLanguage;


@Service
public class ProgrammingLanguagesManager implements IProgrammingLanguagesService{
    private IProgrammingLanguagesRepository programmingLanguagesRepo;
    @Autowired
    public ProgrammingLanguagesManager(IProgrammingLanguagesRepository programmingLanguagesRepo) {
        this.programmingLanguagesRepo = programmingLanguagesRepo;
    }
    @Override
    public List<GetAllProgrammingLanguagesResponse> getAll() {
        List<ProgrammingLanguage> pl;
        List<GetAllProgrammingLanguagesResponse> response = new ArrayList<>();
    
        try {
            pl = programmingLanguagesRepo.findAll();
        } catch (Exception e) {
            // Hata durumunda uygun bir hata mesajı döndürmek veya loglamak
            throw new RuntimeException("An error occurred while fetching programming languages", e);
        }
    
        for (ProgrammingLanguage programmingLanguage : pl) {
            GetAllProgrammingLanguagesResponse plResponse = new GetAllProgrammingLanguagesResponse();
            plResponse.setId(programmingLanguage.getId());
            plResponse.setName(programmingLanguage.getName());
            response.add(plResponse);
        }
        
        return response;
    }
    @Override
    public void add(CreateProgrammingLanguageRequest request) {

        if (programmingLanguagesRepo.existsByName(request.getName())) {
            throw new RuntimeException("A programming language with this name already exists: " + request.getName());
        }

        ProgrammingLanguage pl = new ProgrammingLanguage();
        pl.setName(request.getName());
        programmingLanguagesRepo.save(pl);
    }
    
}
