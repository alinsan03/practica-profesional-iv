package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;

public interface AvailabilityRepository extends JpaRepository <Availability, Integer> {

    Availability findById_gas_stationAndId_type(Integer id_gas_station, Integer id_type);

}
