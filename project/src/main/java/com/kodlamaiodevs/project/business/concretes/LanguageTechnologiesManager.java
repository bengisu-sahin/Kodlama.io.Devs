package com.kodlamaiodevs.project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.ILanguageTechonologyService;
import com.kodlamaiodevs.project.business.requests.CreateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.dataAccess.abstracts.ILanguageTechnologyRepository;
import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import com.kodlamaiodevs.project.entities.LanguageTechnology;
import com.kodlamaiodevs.project.entities.ProgrammingLanguage;

import jakarta.transaction.Transactional;

@Service
public class LanguageTechnologiesManager implements ILanguageTechonologyService {

    private ILanguageTechnologyRepository languageTechnologyRepo;
    private IProgrammingLanguagesRepository programmingLanguagesRepo;
    
    @Autowired
    public LanguageTechnologiesManager(ILanguageTechnologyRepository languageTechnologyRepo, IProgrammingLanguagesRepository programmingLanguagesRepo) {
        this.languageTechnologyRepo = languageTechnologyRepo;
        this.programmingLanguagesRepo = programmingLanguagesRepo;
    }

    @Override
    public List<LanguageTechnology>  getAll() {
       return languageTechnologyRepo.findAll();
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
        LanguageTechnology languageTechnology = new LanguageTechnology();
        ProgrammingLanguage programmingLanguage = programmingLanguagesRepo.findById(request.getProgrammingLanguageId())
                .orElseThrow(() -> new RuntimeException("Programming Language  not found."));

        // Check if language technology with the same name exists
        if (languageTechnologyRepo.existsByName(request.getName())) {
            throw new RuntimeException("Language technology already exists.");
        }

        languageTechnology.setName(request.getName());
        languageTechnology.setProgrammingLanguage(programmingLanguage);
        languageTechnologyRepo.save(languageTechnology);
    }
}
