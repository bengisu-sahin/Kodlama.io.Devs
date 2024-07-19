package com.kodlamaiodevs.project.business.requests;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private int programmingLanguageId;
}
