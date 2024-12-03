package bo.edu.usfa.gasolina.habragasolina.Controllers;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gasstation")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGasStation(@PathVariable Integer id) {
        try {
            gasStationService.deleteGasStation(id);
            return ResponseEntity.ok("Gas station deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<GasStation> updateGasStation(@PathVariable Integer id, @RequestBody GasStation gasStation) {
        GasStation updatedGasStation = gasStationService.updateGasStation(id, gasStation);
        return ResponseEntity.ok(updatedGasStation);
    }
}

