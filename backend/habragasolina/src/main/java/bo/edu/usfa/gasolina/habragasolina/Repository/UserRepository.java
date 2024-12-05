package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import bo.edu.usfa.gasolina.habragasolina.Entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    boolean existsByUsername(String username);
    User findByUsername(String username);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.id_gas_station = :gasStationId")
    boolean existsByGasStationId(@Param("gasStationId") Integer gasStationId);

}
