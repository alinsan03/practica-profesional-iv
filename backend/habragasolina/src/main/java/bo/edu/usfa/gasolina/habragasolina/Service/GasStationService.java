package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import org.springframework.stereotype.Service;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public GasStation saveGasStation(GasStation gasStation) {
        if(gasStation.getName().length() <= 3 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name must be longer than 3 characters");
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
        if (gasStationRepository.existsById(id)) {
            gasStationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Gas station not found, id: " + id);
        }
    }
}

