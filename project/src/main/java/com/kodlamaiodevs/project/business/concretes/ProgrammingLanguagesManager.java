package com.kodlamaiodevs.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.abstracts.IProgrammingLanguagesService;
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
    public List<ProgrammingLanguage> getAll() {
        System.out.println(programmingLanguagesRepo);
        return this.programmingLanguagesRepo.getAll();
    }
    
}
