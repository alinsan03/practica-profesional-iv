package bo.edu.usfa.gasolina.habragasolina.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import bo.edu.usfa.gasolina.habragasolina.Entities.Authentication;
import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Service.UserService;

import jakarta.validation.Valid;

@RestController
@Valid
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

   public UserController(UserService userService) {
    this.userService = userService;
   }

   @PostMapping("")
   public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
    User newUser = userService.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
   }

   @PutMapping("/{id}")
   public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
       boolean updated = userService.updateUser(id, user);
       if (updated) {
           return ResponseEntity.ok("Usuario Actualizado Exitosamente");
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
       }
   }

   
   @PostMapping("/login")
    public ResponseEntity<User> authenticateUser(@RequestBody Authentication authentication) {
        User authenticatedUser = userService.Authenticate(authentication);
        if (authenticatedUser != null) {
            return ResponseEntity.status(HttpStatus.OK).body(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deactivateUser(@PathVariable Long id) {
        try {
            userService.deactivateUser(id);
            return ResponseEntity.ok("Usuario desactivado exitosamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
