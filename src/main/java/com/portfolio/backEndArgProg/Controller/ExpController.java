package com.portfolio.backEndArgProg.Controller;

import com.portfolio.backEndArgProg.Dto.dtoExp;
import com.portfolio.backEndArgProg.Entity.Exp;
import com.portfolio.backEndArgProg.Security.Controller.Mensaje;
import com.portfolio.backEndArgProg.Service.ExpService;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exp")
@CrossOrigin(origins = "https://portfolioargprogramafrontend.web.app")
public class ExpController {
    @Autowired
    ExpService expServ;
    
    @GetMapping("/list")
    public ResponseEntity<List<Exp>> list(){
        List<Exp> list = expServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public  ResponseEntity<?> create(@RequestBody dtoExp dtoexp){
        if(StringUtils.isBlank(dtoexp.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(expServ.existsByName(dtoexp.getName()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Exp exp = new Exp(dtoexp.getName(), dtoexp.getDescrip(), dtoexp.getPuesto());
        expServ.save(exp);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
 
/*
    @GetMapping("/detail/{id}")
    public ResponseEntity<Exp> getById(@PathVariable("id") int id){
        if(!expServ.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Exp exp = expServ.getOne(id).get();
        return new ResponseEntity(exp, HttpStatus.OK);
    }
*/
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!expServ.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        }
        expServ.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminado"), HttpStatus.OK);
    }
    
    @PutMapping("/mod/{id}")
    public ResponseEntity<?> mod(@PathVariable("id") int id, @RequestBody dtoExp dtoexp){
        if(!expServ.existsById(id))
                        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getName()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Exp exp = expServ.getOne(id).get();
        exp.setName(dtoexp.getName());
        exp.setDescrip(dtoexp.getDescrip());
        exp.setPuesto(dtoexp.getPuesto());
        
        expServ.save(exp);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
}
