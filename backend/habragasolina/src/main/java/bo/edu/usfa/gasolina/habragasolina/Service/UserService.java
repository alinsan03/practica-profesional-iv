package bo.edu.usfa.gasolina.habragasolina.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import bo.edu.usfa.gasolina.habragasolina.Entities.User;
import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    private final GasStationRepository gasStationRepository;

    public UserService(UserRepository userRepository, GasStationRepository gasStationRepository) {
        this.userRepository = userRepository;
        this.gasStationRepository = gasStationRepository;
    }
    
    public User saveUser(User user) {

        //validations
        if(user.getPassword().length() <= 6){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Password must be longer or equal than 6 characters");
        }
        
        if(userRepository.existsByUsername(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is duplicated");
        }

        if(user.getUsername().length() <= 3){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserName must be longer than 3 characters");
        }

        if(user.getName().length() <= 3){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Name must be longer than 3 characters");
        }

        if(user.getId_gas_station() < 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IdGasStation should be positive");
        }
        
        if(!gasStationRepository.existsById(user.getId_gas_station())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IdGasSTation does not exists");
        }
        
        user.setPassword(hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    //Hashing method
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
    }
}
