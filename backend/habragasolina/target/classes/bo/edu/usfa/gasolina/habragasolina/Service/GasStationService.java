package bo.edu.usfa.gasolina.habragasolina.service;

import bo.edu.usfa.gasolina.habragasolina.repository.GasStationRepository;
import org.springframework.stereotype.Service;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public void deleteGasStation(Integer id) {
        if (gasStationRepository.existsById(id)) {
            gasStationRepository.deleteById(id);
        } else {
            throw new RuntimeException("Gas station not found, id: " + id);
        }
    }
}

