package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStationAvailability;
import bo.edu.usfa.gasolina.habragasolina.Repository.AvailabilityRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.UserRepository;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;
    private final UserRepository userRepository;

    public GasStationService(GasStationRepository gasStationRepository, UserRepository userRepository) {
        this.gasStationRepository = gasStationRepository;
        this.userRepository = userRepository;
    }

    public GasStation updateGasStation(Integer id, GasStation updatedGasStation) {
        Optional<GasStation> existingGasStation = gasStationRepository.findById(id);
        if (existingGasStation.isPresent()) {
            GasStation gasStation = existingGasStation.get();
            gasStation.setName(updatedGasStation.getName());
            gasStation.setLocation(updatedGasStation.getLocation());
            return gasStationRepository.save(gasStation);
        } else {
            throw new RuntimeException("Gas station not found, id " + id);
        }
    }
    public GasStation saveGasStation(GasStation gasStation) {
        if(gasStation.getName().length() <= 3 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be longer than 3 characters");
        // bad request es 400 para la validacion.
        }
        if(gasStation.getName().length() > 100){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name can't be longer than 100 characters");
        }
        if(gasStationRepository.existsByName(gasStation.getName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This gas station already exists");
        }
        return gasStationRepository.save(gasStation);
    }

    public void deleteGasStation(Integer id) {
        if (userRepository.existsByGasStationId(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "You cannot delete the Gas Station with users");
        }
        if (gasStationRepository.existsById(id)) {
            gasStationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Gas station not found, id: " + id);
        }
    }


    public GasStation getGasStation(Integer id){
        Optional<GasStation> gasStation = gasStationRepository.findById(id);
        return gasStation.orElseThrow(() -> 
            new RuntimeException("Gas station not found, id: " + id));
    }
    public List<GasStationAvailability> getGasStationAvailability() {
        List<GasStation> gasStations = gasStationRepository.findAll();
        List<GasStationAvailability> gasStationsAvailabilities = new ArrayList<>();

        for (GasStation gasStation : gasStations) {
            GasStationAvailability record = new GasStationAvailability();
            record.setName(gasStation.getName());
            record.setLocation(gasStation.getLocation());
            Availability gasolina = getAvailabilityByType(gasStation.getAvailabilities(), 1);
            if(gasolina != null){
                record.setDateGasolina(gasolina.getDate_updated());
                record.setGasolina(gasolina.getId_type());
            }
            Availability premium = getAvailabilityByType(gasStation.getAvailabilities(), 2);
            if(premium != null){
                record.setDatePremium(premium.getDate_updated());
                record.setPremium(premium.getId_type());
            }
            Availability diesel = getAvailabilityByType(gasStation.getAvailabilities(), 3);
            if(diesel != null){
                record.setDateDiesel(diesel.getDate_updated());
                record.setDiesel(diesel.getId_type());
            }    
            gasStationsAvailabilities.add(record);
        }
        return gasStationsAvailabilities;
    }
    private Availability getAvailabilityByType(Set<Availability> availabilities, Integer type){
        for (Availability record : availabilities) {
            if(record.getId_type() == type){
                return record;
            }
        }
        return null;
    }


}

