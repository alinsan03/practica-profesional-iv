package bo.edu.usfa.gasolina.habragasolina.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import bo.edu.usfa.gasolina.habragasolina.Entities.Authentication;
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

        if(user.getUsername().length() <= 3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UserName must be longer than 3 characters");
        }

        if(user.getPassword().length() < 6){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password must be longer or equal than 6 characters");
        }

        if(user.getName().length() <= 3){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be longer than 3 characters");
        }

        if(user.getId_gas_station() <= 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IdGasStation should be positive");
        }
        
        if(userRepository.existsByUsername(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User is duplicated");
        }

        if(!gasStationRepository.existsById(user.getId_gas_station())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IdGasSTation does not exists");
        }
        
        user.setPassword(Security.hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public User Authenticate(Authentication userInformation)
    {
        if(userRepository.existsByUsername(userInformation.getUsername())){
            User user = userRepository.findByUsername(userInformation.getUsername());
            if(user.getPassword() == Security.hashPassword(userInformation.getPassword()))
            {
                return user;
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or password invalid");
    }
    
}
