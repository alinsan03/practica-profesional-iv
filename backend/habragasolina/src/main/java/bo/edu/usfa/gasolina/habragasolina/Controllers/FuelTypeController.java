package bo.edu.usfa.gasolina.habragasolina.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Service.FuelTypeService;


@RestController
@RequestMapping("/fueltype")
public class FuelTypeController {
    private final FuelTypeService fuelTypeService;

    public FuelTypeController(FuelTypeService fuelTypeService) {
        this.fuelTypeService = fuelTypeService;
    }
    @GetMapping("")
    public ResponseEntity<FuelType> getFuelType(@PathVariable Integer id) {
        try {
            FuelType fuelType = fuelTypeService.getFuelType(id);
            return ResponseEntity.ok(fuelType);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
