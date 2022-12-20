package com.portfolio.backEndArgProg.Controller;

import com.portfolio.backEndArgProg.Dto.dtoEduc;
import com.portfolio.backEndArgProg.Entity.Educ;
import com.portfolio.backEndArgProg.Security.Controller.Mensaje;
import com.portfolio.backEndArgProg.Service.EducService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/educ")
@CrossOrigin(origins = "http://localhost:4200")
public class EducController {
    @Autowired
    EducService educServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Educ>> list(){
        List<Educ> list = educServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> create(@RequestBody dtoEduc dtoeduc){
        if(StringUtils.isBlank(dtoeduc.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educ educ = new Educ(dtoeduc.getName(), dtoeduc.getLugar());
        educServ.save(educ);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        educServ.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
}
