package com.portfolio.backEndArgProg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String lugar;

    public Educ() {
    }

    public Educ(String name, String lugar) {
        this.name = name;
        this.lugar = lugar;
    }

    public Educ(String name) {
        this.name = name;
    }
    
    
    
}
