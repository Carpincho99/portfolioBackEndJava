
package com.portfolio.backEndArgProg.Repository;

import com.portfolio.backEndArgProg.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{
    
}
