package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStationEntity;
import bo.edu.usfa.gasolina.habragasolina.Repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GasStationService {

    private final GasStationRepository gasStationRepository;

    @Autowired
    public GasStationService(GasStationRepository gasStationRepository) {
        this.gasStationRepository = gasStationRepository;
    }

    public GasStationEntity saveGasStation(GasStationEntity gasStation) {
        return gasStationRepository.save(gasStation);
    }

    public List<GasStationEntity> getAllGasStation() {
        return gasStationRepository.findAll();
    }

    public Optional<GasStationEntity> getGasStationById(Long id) {
        return gasStationRepository.findById(id);
    }
}

