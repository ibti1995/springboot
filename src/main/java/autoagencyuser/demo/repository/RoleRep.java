package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.Role;
import org.hibernate.tool.hbm2ddl.SchemaExportTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRep extends JpaRepository<Role, Integer>{

}
