package com.kodlamaiodevs.project.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaiodevs.project.entities.ProgrammingLanguage;

public interface IProgrammingLanguagesRepository  extends JpaRepository<ProgrammingLanguage, Integer> {
    boolean existsByName(String name); //we dont't have to implement methods like this bcs jpa implements it by scans our code. We have to be careful about naming the methods. With this method, you can benefit from the opportunities offered by Spring Data JPA, without having to write usually simple queries yourself (such as existByName, findBy..., deleteBy...).
}
