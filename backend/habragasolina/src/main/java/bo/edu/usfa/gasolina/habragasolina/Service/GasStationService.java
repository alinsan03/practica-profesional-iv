package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStationAvailability;
import bo.edu.usfa.gasolina.habragasolina.Entities.Status;
import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;
import bo.edu.usfa.gasolina.habragasolina.Repository.AvailabilityRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.FuelTypeRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.UserRepository;
import bo.edu.usfa.gasolina.habragasolina.Repository.StatusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;
    private final UserRepository userRepository;
    private final AvailabilityRepository availabilityRepository;
    private final FuelTypeRepository fuelTypeRepository ;
    private final StatusRepository statusRepository;

    public GasStationService(GasStationRepository gasStationRepository, UserRepository userRepository, AvailabilityRepository availabilityRepository, StatusRepository statusRepository, FuelTypeRepository fuelTypeRepository) {
        this.gasStationRepository = gasStationRepository;
        this.userRepository = userRepository;
        this.availabilityRepository = availabilityRepository;
        this.statusRepository = statusRepository;
        this.fuelTypeRepository = fuelTypeRepository;
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
    public List<GasStation> getAllGasStations() {
        return gasStationRepository.findAll();
    }
    
    private Availability getAvailabilityByType(Set<Availability> availabilities, Integer type){
        for (Availability record : availabilities) {
            if(record.getId_type() == type){
                return record;
            }
        }
        return null;
    }

    public void upsertAvailability(Integer gasStationId, Integer idFuelType, Integer idStatus) {
        GasStation gasStation = gasStationRepository.findById(gasStationId)
                .orElseThrow(() -> new RuntimeException("GasStation not found"));

        Status status = statusRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        FuelType fuelType= fuelTypeRepository.findById(idFuelType)
                .orElseThrow(() -> new RuntimeException("FuelType not found"));

        if (gasStationId == null || gasStationId < 0 || idFuelType == null || idFuelType <= 0 || idStatus == null || idStatus <= 0) {
            throw new RuntimeException("FuelType or Status or GasStation not valid");
        }

        Availability availability = availabilityRepository.findById_gas_stationAndId_type(gasStationId, idFuelType);
        if(availability==null)
        {
            availability = new Availability();
            availability.setId_gas_station(gasStationId);
            availability.setId_type(idFuelType);
                        
        }
        availability.setId_gas_station(gasStation.getId());
        availability.setId_status(status.getId());
        availability.setId_fuel_type(fuelType.getId());
        availability.setDate_updated(java.time.LocalDateTime.now());

        availabilityRepository.save(availability);
    }


}

