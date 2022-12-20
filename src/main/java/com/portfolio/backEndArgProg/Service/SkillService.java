package com.portfolio.backEndArgProg.Service;

import com.portfolio.backEndArgProg.Entity.Skill;
import com.portfolio.backEndArgProg.Repository.SkillRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillService {
    @Autowired
    SkillRepository skillRepo;
    
    public List<Skill> list(){
         return skillRepo.findAll();
     }
     
     public void save(Skill skill){
         skillRepo.save(skill);
     }
     
     public void delete(int id){
         skillRepo.deleteById(id);
     }
     
     public boolean existsById(int id){
         return skillRepo.existsById(id);
     }
            
}
