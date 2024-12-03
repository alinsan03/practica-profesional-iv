package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
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

    public void deleteGasStation(Integer id) {
        if (gasStationRepository.existsById(id)) {
            gasStationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Gas station not found, id: " + id);
        }
    }
    
}

