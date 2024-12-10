package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;

@Repository
public interface AvailabilityRepository extends JpaRepository <Availability, Integer> {

   @Query("SELECT COUNT(u) > 0 FROM Availability u WHERE u.id_gas_station = :gasStationId")
   Boolean existsByGasStationId(@Param("gasStationId") Integer gasStationId);
}
