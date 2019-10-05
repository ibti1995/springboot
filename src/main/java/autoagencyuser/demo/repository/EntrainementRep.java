package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.Entrainement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrainementRep extends JpaRepository<Entrainement, Long> {
}
