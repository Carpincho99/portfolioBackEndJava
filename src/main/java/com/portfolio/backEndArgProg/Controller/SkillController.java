package com.portfolio.backEndArgProg.Controller;

import com.portfolio.backEndArgProg.Dto.dtoSkill;
import com.portfolio.backEndArgProg.Entity.Skill;
import com.portfolio.backEndArgProg.Security.Controller.Mensaje;
import com.portfolio.backEndArgProg.Service.SkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "https://portfolioargprogramafrontend.web.app")
public class SkillController {
    @Autowired
    SkillService skillServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = skillServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
        if(StringUtils.isBlank(dtoskill.getIcon()))
            return new ResponseEntity(new Mensaje("El icon es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = new Skill(dtoskill.getPorcentaje(), dtoskill.getIcon());
        skillServ.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        skillServ.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
