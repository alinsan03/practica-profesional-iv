package bo.edu.usfa.gasolina.habragasolina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
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
        // if(user.getPassword().length() <= 6){
        //     throw new RuntimeException("Password must be longer or equal than 6 characters");
        // }
        
        // if(userRepository.existsByUsername(user.getUsername())){
        //     throw new RuntimeException("Username must be unique");
        // }

        // if(user.getUsername().length() <= 3){
        //     throw new RuntimeException("UserName must be longer than 3 characters");
        // }

        // if(user.getName().length() <= 3){
        //     throw new RuntimeException("Name must be longer than 3 characters");
        // }

        // if(user.getId_gas_station() < 0){
        //     throw new RuntimeException("IdGasStation should be positive");
        // }
        
        // if(!gasStationRepository.existsById(user.getGasStation().getId())){
        //     throw new RuntimeException("Gas station does not exists");
        // }
        
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
    public User updateUser(Long id, User updateUser){
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            user.setName(updateUser.getName());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
