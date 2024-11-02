package org.example.Parcial_Desarrollo.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.Parcial_Desarrollo.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
