package bo.edu.usfa.gasolina.habragasolina.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;
import bo.edu.usfa.gasolina.habragasolina.Repository.FuelTypeRepository;


@Service
public class FuelTypeService {

        private final FuelTypeRepository fuelTypeRepository;

        public FuelTypeService(FuelTypeRepository fuelTypeRepository) {
            this.fuelTypeRepository = fuelTypeRepository;
        }

    public List<FuelType> getAllFuelTypes() {
        return fuelTypeRepository.findAll();
    }

}
