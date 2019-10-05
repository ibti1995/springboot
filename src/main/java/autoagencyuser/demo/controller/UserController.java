package autoagencyuser.demo.controller;
import autoagencyuser.demo.model.User;
import autoagencyuser.demo.repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = { "http://localhost:3000","http://localhost:5000"})
@RestController
public class UserController {
    @Autowired
    private UserRep userRep ;

    @PostMapping("/admin/subscribe")
    public User createUser (@Valid @RequestBody User user){

       return userRep.save(user);
    }
    @PostMapping("/login/{email}")
    public User loginUser(@PathVariable String email,
                                     @Valid @RequestBody User user) {
        return userRep.findByEmail(email);
          }


}
