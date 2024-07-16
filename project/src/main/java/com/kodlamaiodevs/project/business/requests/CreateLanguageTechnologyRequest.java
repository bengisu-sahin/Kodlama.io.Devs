package com.kodlamaiodevs.project.business.requests;
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
public class CreateLanguageTechnologyRequest {
    private String name;
    private int programmingLanguageId;
}
