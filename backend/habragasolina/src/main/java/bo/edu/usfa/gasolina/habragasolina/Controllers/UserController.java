package bo.edu.usfa.gasolina.habragasolina.Controllers;

import java.util.List;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/habra_gasolina")
public class UserController {

    private final UserService userService;

   public UserController(UserService userService) {
    this.userService = userService;
   }

   @PostMapping("/user")
   public ResponseEntity<User> saveUser(@RequestBody User user){
    User newUser = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
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
