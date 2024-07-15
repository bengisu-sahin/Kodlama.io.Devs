package com.kodlamaiodevs.project.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import com.kodlamaiodevs.project.entities.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements IProgrammingLanguagesRepository {

    private List<ProgrammingLanguage> programmingLanguages;
    
    public InMemoryProgrammingLanguageRepository() {
        programmingLanguages = new ArrayList<ProgrammingLanguage>();
        programmingLanguages.add(new ProgrammingLanguage(1, "Java"));
        programmingLanguages.add(new ProgrammingLanguage(2, "C#"));
        programmingLanguages.add(new ProgrammingLanguage(3, "Python"));
        programmingLanguages.add(new ProgrammingLanguage(4, "JavaScript"));
        programmingLanguages.add(new ProgrammingLanguage(5, "C++"));
        System.out.println(programmingLanguages.get(0).getName());
    }
  

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }


    @Override
    public ProgrammingLanguage getByID(int id) {
        for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getID() == id) {
                return programmingLanguage;
            }
        }
        return null;
    }
    
}
