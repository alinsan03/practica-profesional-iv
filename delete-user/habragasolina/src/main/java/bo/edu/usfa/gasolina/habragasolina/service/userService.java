package bo.edu.usfa.gasolina.habragasolina.service;

import bo.edu.usfa.gasolina.habragasolina.entity.User;
import bo.edu.usfa.gasolina.habragasolina.repository.userRepository;
import org.springframework.stereotype.Service;

@Service
public class userService {

    private final userRepository userRepository;

    // Constructor para inyectar UserRepository
    public userService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id) {
        // Buscar el usuario activo por ID
        User user = userRepository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new RuntimeException("User not found, id: " + id));

        // Marcar como inactivo en lugar de eliminar
        user.setActive(false);
        userRepository.save(user);
    }
}