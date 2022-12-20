package com.portfolio.backEndArgProg.Service;

import com.portfolio.backEndArgProg.Entity.Exp;
import com.portfolio.backEndArgProg.Repository.ExpRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExpService {
    @Autowired
    ExpRepository xpRepo;
    
     public List<Exp> list(){
         return xpRepo.findAll();
     }
     
     public Optional<Exp> getOne(int id){
         return xpRepo.findById(id);
     }
     
     public Optional<Exp> getByName(String name){
         return xpRepo.findByName(name);
     }
     
     public void save(Exp exp){
         xpRepo.save(exp);
     }
     
     public void delete(int id){
         xpRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return xpRepo.existsById(id);
     }
     
     public boolean existsByName(String name){
         return xpRepo.existsByName(name);
     }
}
