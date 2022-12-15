package com.portfolio.backEndArgProg.Security.Service;

import com.portfolio.backEndArgProg.Security.Entity.Rol;
import com.portfolio.backEndArgProg.Security.Enums.RolNombre;
import com.portfolio.backEndArgProg.Security.Repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepo;
    
    public Optional<Rol> getByRolNombre(RolNombre rolnombre){
        return irolRepo.findByRolNombre(rolnombre);
    }
    
    public void save(Rol rol){
        irolRepo.save(rol);
    }
}
