package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRep extends JpaRepository<Examen, Long> {
}
