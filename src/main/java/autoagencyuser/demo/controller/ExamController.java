package autoagencyuser.demo.controller;

import autoagencyuser.demo.exceptions.ResourceNotFoundException;
import autoagencyuser.demo.model.Examen;
import autoagencyuser.demo.repository.ExamenRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = { "http://localhost:3000","http://localhost:5000"})
@RestController
public class ExamController {


    @Autowired
    private ExamenRep examenRep;
    @PostMapping("/addExam")
    public Examen createExamen (@Valid @RequestBody Examen ex){
        return  examenRep.save(ex);
    }
    /******************************************/

    @GetMapping("/admin/showListExam")
    public Page<Examen> getExam(Pageable p) { return  examenRep.findAll(p);
    }
    /****************************************/
    @DeleteMapping("/admin/examen/{id}")
    public ResponseEntity<?> deleteExamen(@PathVariable Long id) {
        return examenRep.findById(id)
                .map(exam -> {
                    examenRep.delete(exam);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("exam not found with id " + id));
    }
    @PutMapping("/exam/{id}")
    public Examen updateExamen(@PathVariable Long id,
                                     @Valid @RequestBody Examen examenRequest) {
        return examenRep.findById(id)
                .map(exam -> {
                    exam.setTitre(examenRequest.getTitre());
                    exam.setDateExam(examenRequest.getDateExam());
                    exam.setStatut(examenRequest.getTitre());
                    return examenRep.save(exam);
                }).orElseThrow(() -> new ResourceNotFoundException("exam not found with id " + id));
    }

}
