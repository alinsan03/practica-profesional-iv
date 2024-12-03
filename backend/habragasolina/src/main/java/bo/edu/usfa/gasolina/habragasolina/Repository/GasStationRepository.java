package bo.edu.usfa.gasolina.habragasolina.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasStationRepository extends JpaRepository<GasStation, Integer> {
}
