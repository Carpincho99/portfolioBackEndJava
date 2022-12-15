package com.portfolio.backEndArgProg.Security.Service;

import com.portfolio.backEndArgProg.Security.Entity.Usuario;
import com.portfolio.backEndArgProg.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepo;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario (String nombreUsuario){
        return iusuarioRepo.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail (String email){
        return iusuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepo.save(usuario);
    }
    
}
