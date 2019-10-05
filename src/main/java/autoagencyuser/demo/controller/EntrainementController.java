package autoagencyuser.demo.controller;

import autoagencyuser.demo.exceptions.ResourceNotFoundException;
import autoagencyuser.demo.model.Entrainement;
import autoagencyuser.demo.repository.EntrainementRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = { "http://localhost:3000","http://localhost:5000"})
@RestController
public class EntrainementController {
    @Autowired
    private EntrainementRep entrainementRep;

    @PostMapping("/admin/addTraining")
    public Entrainement createExamen (@Valid @RequestBody Entrainement entrainement){
        return  entrainementRep.save(entrainement);
    }
    @GetMapping("/admin/showListTraining")
    public Page<Entrainement> getExam(Pageable p) { return entrainementRep.findAll(p);
    }
/*****************************************************************/

@DeleteMapping("/admin/entrainement/{id}")
public ResponseEntity<?> deleteEntrainement(@PathVariable Long id) {
    return entrainementRep.findById(id)
            .map(entrainement -> {
                entrainementRep.delete(entrainement
                );
                return ResponseEntity.ok().build();
            }).orElseThrow(() -> new ResourceNotFoundException("training not found with id " + id));
}
    @PutMapping("/admin/updateTraning/{id}")
    public Entrainement updateentrainement(@PathVariable Long id,
                               @Valid @RequestBody Entrainement entrainementRequest) {
        return entrainementRep.findById(id)
                .map(training -> {
                    training.setDescEntrainement(entrainementRequest.getDescEntrainement());
                    training.setTitreEntrainement(entrainementRequest.getTitreEntrainement());
                    training.setTypeEntrainement(entrainementRequest.getTypeEntrainement());
                    training.setUrl(entrainementRequest.getUrl());
                    return entrainementRep.save(training);
                }).orElseThrow(() -> new ResourceNotFoundException("training not found with id " + id));
    }


}
