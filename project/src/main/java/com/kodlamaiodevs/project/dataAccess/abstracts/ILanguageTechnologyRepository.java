package com.kodlamaiodevs.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaiodevs.project.entities.LanguageTechnology;

public interface ILanguageTechnologyRepository extends JpaRepository<LanguageTechnology,Integer> {
    
    LanguageTechnology getLanguageTechnologyById(Integer id);
}
