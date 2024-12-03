package bo.edu.usfa.gasolina.habragasolina.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasStationRepository extends JpaRepository<GasStationEntity, Long> {
    GasStationEntity findByLocation(String location);
}
