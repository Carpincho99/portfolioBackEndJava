package com.portfolio.backEndArgProg.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoSkill {
    @NotBlank
    @Size(min=1)
    private int porcentaje;
    @NotBlank
    private String icon;

    public dtoSkill() {
    }

    public dtoSkill(int porcentaje, String icon) {
        this.porcentaje = porcentaje;
        this.icon = icon;
    }
    
    
}
