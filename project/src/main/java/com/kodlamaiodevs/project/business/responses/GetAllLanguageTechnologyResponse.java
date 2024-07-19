package com.kodlamaiodevs.project.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllLanguageTechnologyResponse {
    private int id;
    private String name;
    private String programmingLanguageName;
}
