package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRep extends JpaRepository<Role, Long>{
}
