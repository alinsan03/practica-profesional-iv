package bo.edu.usfa.gasolina.habragasolina.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;

@Repository
public interface GasStationRepository extends JpaRepository <GasStation, Integer> {
    boolean existsByName(String username);
}
