package com.kodlamaiodevs.project.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.ILanguageTechonologyService;
import com.kodlamaiodevs.project.dataAccess.abstracts.ILanguageTechnologyRepository;
import com.kodlamaiodevs.project.entities.LanguageTechnology;

@Service
public class LanguageTechnologiesManager implements ILanguageTechonologyService {

    private ILanguageTechnologyRepository languageTechnologyRepo;

    @Autowired
    public LanguageTechnologiesManager(ILanguageTechnologyRepository languageTechnologyRepo) {
        this.languageTechnologyRepo = languageTechnologyRepo;
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

}
