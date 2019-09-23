package autoagencyuser.demo.controller;

import autoagencyuser.demo.model.PermisAuto;
import autoagencyuser.demo.model.User;
import autoagencyuser.demo.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserRep userRep ;
    @PostMapping("/subscribe")
    public User createUser (@Valid @RequestBody User user){
        return  userRep.save(user);
    }
    @PostMapping("/login/{email}")
    public User loginUser(@PathVariable String email,
                                     @Valid @RequestBody User user) {
        return userRep.findByEmail(email);
          }


}
