package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    boolean existsByUsername(String username);
}
