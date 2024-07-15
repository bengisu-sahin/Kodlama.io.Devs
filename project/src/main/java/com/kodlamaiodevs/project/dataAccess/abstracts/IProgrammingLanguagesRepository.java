package com.kodlamaiodevs.project.dataAccess.abstracts;

import java.util.List;

import com.kodlamaiodevs.project.entities.ProgrammingLanguage;

public interface IProgrammingLanguagesRepository  {
    List<ProgrammingLanguage> getAll();
    ProgrammingLanguage getByID(int id);

}
