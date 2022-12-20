package com.portfolio.backEndArgProg.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Exp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String puesto;
    
    @Column(length = 8000)
    private String descrip;

    public Exp() {
    }

    public Exp(String name, String descrip, String puesto) {
        this.name = name;
        this.puesto= puesto;
        this.descrip = descrip;
    }
    
    
}
