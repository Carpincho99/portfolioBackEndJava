
package com.portfolio.backEndArgProg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(max=80, message="[ERROR] MaxLenght")
    private String nombre;
    
    @NotNull
    @Size(max=80, message="[ERROR] MaxLenght")
    private String apellido;
    
    private String img;
    
    
}
