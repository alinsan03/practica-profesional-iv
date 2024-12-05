package bo.edu.usfa.gasolina.habragasolina.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Repository.FuelTypeRepository;

@Service
public class FuelTypeService {
    private final FuelTypeRepository fuelTypeRepository;

    public FuelTypeService(FuelTypeRepository fuelTypeRepository) {
        this.fuelTypeRepository = fuelTypeRepository;
    }
    public FuelType getFuelType(Integer id){
        Optional<FuelType> fuelType = fuelTypeRepository.findById(id);
        return fuelType.orElseThrow(() -> 
            new RuntimeException("Fuel type " + id +" not founded"));
    }
}
