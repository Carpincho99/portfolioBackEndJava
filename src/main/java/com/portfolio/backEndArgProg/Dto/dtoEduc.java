package com.portfolio.backEndArgProg.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEduc {
    @NotBlank
    String name;
    String lugar;

    public dtoEduc() {
    }

    public dtoEduc(String name, String lugar) {
        this.name = name;
        this.lugar = lugar;
    }

    public dtoEduc(String name) {
        this.name = name;
    }
    
    
    
}
