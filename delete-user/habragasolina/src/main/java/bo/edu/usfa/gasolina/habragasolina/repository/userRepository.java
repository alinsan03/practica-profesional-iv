package bo.edu.usfa.gasolina.habragasolina.repository;

import bo.edu.usfa.gasolina.habragasolina.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndActiveTrue(Long id); // Método personalizado
}
