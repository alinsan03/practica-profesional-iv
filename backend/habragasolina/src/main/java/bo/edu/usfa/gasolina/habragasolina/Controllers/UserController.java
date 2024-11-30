package bo.edu.usfa.gasolina.habragasolina.Controllers;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Service.UserService;
import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

   @Autowired
   public UserController(UserService userService) {
    this.userService = userService;
   }

   @PostMapping("/user")
   public ResponseEntity<User> saveUser(@RequestBody User user){
    User newUser = userService.saveUser(user);
    return ResponseEntity.ok(newUser);
   }

   @GetMapping("/users")
   public List<User> getAllUsers() {
    return userService.getAllUsers();
   }

   @GetMapping("/users/{id}")
   public ResponseEntity<User> getUserById(@PathVariable Long id) {
    Optional<User> user = userService.getUserById(id);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @PutMapping("/users/{id}")
   public ResponseEntity<User> putMethodName(@PathVariable Long id, @RequestBody User user) {
       User updateUser = userService.updateUser(id, user);
       return ResponseEntity.ok(updateUser);
   }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delEntity(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
   
   
}
