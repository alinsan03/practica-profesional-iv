package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;


@Repository
public interface AvailabilityRepository extends JpaRepository <Availability, Integer> {
   @Query("SELECT a FROM Availability a WHERE a.gasStationId = :gasStationId AND a.typeId = :typeId")
   Availability findByIdGasStationIdAndTypeId(@Param("gasStationId") Integer gasStationId, @Param("typeId") Integer typeId);

}
