package bo.edu.usfa.gasolina.habragasolina.Controllers;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gasstation")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @PostMapping("")
    public ResponseEntity<GasStation> saveGasStation(@RequestBody GasStation gasStation) {
        GasStation newGasStation = gasStationService.saveGasStation(gasStation);
        return ResponseEntity.ok(newGasStation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GasStation> updateGasStation(@PathVariable Integer id, @RequestBody GasStation gasStation) {
        GasStation updatedGasStation = gasStationService.updateGasStation(id, gasStation);
        return ResponseEntity.ok(updatedGasStation);
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

    @GetMapping("/{id}")
    public ResponseEntity<GasStation> getGasStation(@PathVariable Integer id) {
        try {
            GasStation gasStation = gasStationService.getGasStation(id);
            return ResponseEntity.ok(gasStation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }    
    
    @GetMapping("")
    public ResponseEntity<List<GasStation>> getAllGasStations() {
        try {
            List<GasStation> gasStations = gasStationService.getAllGasStations(); 
            return ResponseEntity.ok(gasStations);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); 
        }
    }


    @GetMapping("/availability")
    public ResponseEntity<Object> getGasStationAvailability() {
        try {
            return ResponseEntity.ok(gasStationService.getGasStationAvailability());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching gas station availability: " + e.getMessage());
        }
    }

}

