package com.kodlamaiodevs.project.business.abstracts;

import java.util.List;

import com.kodlamaiodevs.project.business.requests.CreateLanguageTechnologyRequest;
import com.kodlamaiodevs.project.entities.LanguageTechnology;

public interface ILanguageTechonologyService {
    public List<LanguageTechnology> getAll();
    public List<LanguageTechnology> getByLanguageName(int id);
    public void add(CreateLanguageTechnologyRequest request);
}
