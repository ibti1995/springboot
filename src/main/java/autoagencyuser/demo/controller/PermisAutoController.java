package autoagencyuser.demo.controller;

import autoagencyuser.demo.exceptions.ResourceNotFoundException;
import autoagencyuser.demo.model.PermisAuto;
import autoagencyuser.demo.repository.PermisAutoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000","http://localhost:5000"})
@RestController
public class PermisAutoController {
    @Autowired
    private PermisAutoRep permisAutoRep;
    @PostMapping("/add")
    public PermisAuto createPermisAuto (@Valid @RequestBody PermisAuto permis){
        return  permisAutoRep.save(permis);
    }
    @GetMapping("/admin/showpermis")
    public Page<PermisAuto> getPermis(Pageable p) {
        return permisAutoRep.findAll(p);
    }
    @DeleteMapping("/admin/permis/{id}")
    public ResponseEntity<?> deletePermis(@PathVariable Long id) {
        return permisAutoRep.findById(id)
                .map(question -> {
                    permisAutoRep.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }
    @PutMapping("/permis/{id}")
    public PermisAuto updateQuestion(@PathVariable Long id,
                                   @Valid @RequestBody PermisAuto permisAutoRequest) {
        return permisAutoRep.findById(id)
                .map(permisAuto -> {
                    permisAuto.setTitre(permisAutoRequest.getTitre());
                    permisAuto.setDescription(permisAutoRequest.getDescription());
                    permisAuto.setPrix(permisAutoRequest.getPrix());
                    return permisAutoRep.save(permisAuto);
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
    }
}
