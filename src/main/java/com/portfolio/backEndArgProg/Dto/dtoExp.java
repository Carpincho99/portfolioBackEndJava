package com.portfolio.backEndArgProg.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExp {
    @NotBlank
    private String name;
    @NotBlank
    private String puesto;
    
    @NotBlank
    @Column(length = 8000)
    private String descrip;

    public dtoExp() {
    }

    public dtoExp(String name, String descrip, String puesto) {
        this.name = name;
        this.puesto = puesto;
        this.descrip = descrip;
    }
    
   
}
