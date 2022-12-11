package com.portfolio.backEndArgProg.Interface;

import com.portfolio.backEndArgProg.Entity.Persona;
import java.util.List;


public interface InterfacePersonaService {
   public List<Persona> getPersonas(); 
   
   public void savePersona (Persona persona);
   
   public void deletePersona (Long id);
   
   public Persona findPersona (Long id);
}
