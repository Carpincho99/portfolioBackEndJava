package com.portfolio.backEndArgProg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        
    private int porcentaje;
    private String icon;

    public Skill() {
    }

    public Skill(int porcentaje, String icon) {
        this.porcentaje = porcentaje;
        this.icon = icon;
    }
    
    
}
