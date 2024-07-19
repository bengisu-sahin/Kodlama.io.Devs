package com.kodlamaiodevs.project.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "programminglanguages")
@Entity
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "programmingLanguage",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<LanguageTechnology> languageTechnologies;
}