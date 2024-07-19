package com.kodlamaiodevs.project.business.rules;

import org.springframework.stereotype.Service;

import com.kodlamaiodevs.project.business.core.utilities.exceptions.BusinessException;
import com.kodlamaiodevs.project.dataAccess.abstracts.IProgrammingLanguagesRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRule {
    private IProgrammingLanguagesRepository programmingLanguagesRepository;
    public void checkifPRogrammingLanguageExists(String name) {
        if(this.programmingLanguagesRepository.existsByName(name)) {
            throw new BusinessException("Programming language already exists.");
        }
    }
}
