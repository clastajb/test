package com.antsrl.formazione.springbasics.uimodel;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;


@Builder
@Getter
@Setter
public class Song {

    private Long id;
    @NotEmpty(message = "il titolo è obbligatorio")
    @Size(min = 3, max = 50, message = "il titolo deve essere di minimo 3 lettere e massimo 50 lettere")
    private String title;
    @URL
    private String url;

}
