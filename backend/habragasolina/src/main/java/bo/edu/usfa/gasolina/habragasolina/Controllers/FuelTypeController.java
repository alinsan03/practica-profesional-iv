package bo.edu.usfa.gasolina.habragasolina.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;
import bo.edu.usfa.gasolina.habragasolina.Service.FuelTypeService;

@RestController
@RequestMapping("/fueltype")
public class FuelTypeController {

    private final FuelTypeService fuelTypeService;

    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }

    @GetMapping("")
    public List<FuelType> getAllFuelTypes() {
        return fuelTypeService.getAllFuelTypes();
    }
}
