package com.portfolio.backEndArgProg.Service;

import com.portfolio.backEndArgProg.Entity.Persona;
import com.portfolio.backEndArgProg.Interface.InterfacePersonaService;
import com.portfolio.backEndArgProg.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements InterfacePersonaService {

    @Autowired
    private PersonaRepository personaRepo;
    
    @Override
    public List<Persona> getPersonas() {
        List<Persona> listPersona = personaRepo.findAll();
        return listPersona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = personaRepo.findById(id).orElse(null);
        return persona;
    }
    
}
