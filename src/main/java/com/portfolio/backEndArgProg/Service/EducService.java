package com.portfolio.backEndArgProg.Service;

import com.portfolio.backEndArgProg.Entity.Educ;
import com.portfolio.backEndArgProg.Repository.EducRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducService {
    @Autowired
    EducRepository educRepo;
    
    public List<Educ> list(){
         return educRepo.findAll();
     }
     
     public Optional<Educ> getOne(int id){
         return educRepo.findById(id);
     }
     
     public Optional<Educ> getByName(String name){
         return educRepo.findByName(name);
     }
     
     public void save(Educ exp){
         educRepo.save(exp);
     }
     
     public void delete(int id){
         educRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return educRepo.existsById(id);
     }
     
     public boolean existsByName(String name){
         return educRepo.existsByName(name);
     }
}
