
package com.portfolio.backEndArgProg.Controller;

import com.portfolio.backEndArgProg.Entity.Persona;
import com.portfolio.backEndArgProg.Interface.InterfacePersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private InterfacePersonaService interPersona;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }
    
    @PostMapping ("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        interPersona.savePersona(persona);
        return "Persona creada";
    }
    
    @DeleteMapping ("personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "Persona eliminada";
    }

    @PutMapping ("personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam ("nombre") String nvoNombre,
                               @RequestParam ("apellido") String nvoApellido) {
     
      Persona persona = interPersona.findPersona(id);
      persona.setNombre(nvoNombre);
      persona.setApellido(nvoNombre);

      interPersona.savePersona(persona);
      return persona;
    }
}

