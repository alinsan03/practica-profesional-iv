package bo.edu.usfa.gasolina.habragasolina.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.usfa.gasolina.habragasolina.Entities.Authentication;
import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

   public UserController(UserService userService) {
    this.userService = userService;
   }

   @PostMapping("")
   public ResponseEntity<User> saveUser(@RequestBody User user){
    User newUser = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
   }

   @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(
            @PathVariable("id") Long id, 
            @RequestBody User user) {
        boolean updated = userService.updateUser(id, user);
        if (updated) {
            return ResponseEntity.ok("updated user successfully");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }
   
   @PostMapping("/login")
   public ResponseEntity<User> aunthenticateUser(@RequestBody Authentication user){
    User newUser = userService.Authenticate(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deactivateUser(@PathVariable Long id) {
        try {
            userService.deactivateUser(id);
            return ResponseEntity.ok("User deactivated successfully.");
        } catch (RuntimeException e) {
            if (e.getMessage().contains("not found")) {
                return ResponseEntity.status(404).body(e.getMessage());
            }
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
