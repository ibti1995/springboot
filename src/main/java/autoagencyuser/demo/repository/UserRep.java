package autoagencyuser.demo.repository;

import autoagencyuser.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
    User findByEmail(String email);


}