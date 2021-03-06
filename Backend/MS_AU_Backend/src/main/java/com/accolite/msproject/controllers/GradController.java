package com.accolite.msproject.controllers;

import com.accolite.msproject.model.Audit;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.service.AuditService;
import com.accolite.msproject.service.GradService;
import com.accolite.msproject.service.impl.GradServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grad")
public class GradController {

    @Autowired
    private GradService gradService;

    @Autowired
    private AuditService auditService;

    //Method to fetch all the grads in the grad table and return type is as an response entity

    @GetMapping("/all")
    public ResponseEntity<List<Grad>> getAllGrads(){
        List<Grad> grads=gradService.findAllGrads();
        return new ResponseEntity<>(grads, HttpStatus.OK);
    }

    //Method to fetch the grad by its id from the grad table and return type is as an response entity

    @GetMapping("/find/{id}")
    public ResponseEntity<Grad> getGradById(@PathVariable("id") Integer id){
        Grad grad=gradService.findGradById(id);
        return new ResponseEntity<>(grad, HttpStatus.OK);
    }

    //Method to add a grad in the grad table with the users email and name (for audit) and return type is as an response entity

    @PostMapping("/add")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Grad> addGrad(@RequestBody Grad grad,@RequestHeader(value = "Email") String email,@RequestHeader(value = "Name") String userName)
    {
        Grad newGrad=gradService.addGrad(grad);
        int resp = auditService.insertAudit(new Audit(userName,email,"Add","",grad.toString()));
        return new ResponseEntity<>(newGrad,HttpStatus.CREATED);
    }

    //Method to update a grad in the grad table with the users email and name (for audit) and return type is as an response entity

    @PutMapping("/update")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Grad> updateGrad(@RequestBody Grad grad,@RequestHeader(value = "Email") String email,@RequestHeader(value = "Name") String userName)
    {
        Grad oldGrad = gradService.findGradById(grad.getId());
        int resp = auditService.insertAudit(new Audit(userName,email,"Update",oldGrad.toString(),grad.toString()));
        Grad updatedGrad=gradService.updateGrad(grad);
        return new ResponseEntity<>(updatedGrad,HttpStatus.OK);
    }

    //Method to delete a grad in the grad table with the users email and name (for audit) and return type is as an response entity

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<?> deleteGrad(@PathVariable("id") Integer id,@RequestHeader(value = "Email") String email,@RequestHeader(value = "Name") String userName){
        Grad oldGrad = gradService.findGradById(id);
        gradService.deleteById(id);
        int resp = auditService.insertAudit(new Audit(userName,email,"Delete",oldGrad.toString(),""));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
