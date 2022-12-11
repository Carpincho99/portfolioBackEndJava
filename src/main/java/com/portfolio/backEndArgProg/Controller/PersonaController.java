
package com.portfolio.backEndArgProg.Controller;

import com.portfolio.backEndArgProg.Entity.Persona;
import com.portfolio.backEndArgProg.Interface.InterfacePersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private InterfacePersonaService interPersona;
    
    @GetMapping ("/persona/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping ("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
        interPersona.savePersona(persona);
        return "Persona creada";
    }
    
}

