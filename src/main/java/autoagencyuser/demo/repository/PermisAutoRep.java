package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.PermisAuto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermisAutoRep extends JpaRepository<PermisAuto, Long> {
}
