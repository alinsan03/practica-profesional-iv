package bo.edu.usfa.gasolina.habragasolina.Controllers;

import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Request.AvailabilityRequest;
import bo.edu.usfa.gasolina.habragasolina.Service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
    
    @GetMapping("/gasstations")
    public ResponseEntity<Map<String, Object>> getAllGasStations() {
        List<GasStation> gasStations = gasStationService.getAllGasStations();
       Map<String, Object> response = new HashMap<>();
       response.put("data", gasStations);
       return ResponseEntity.ok(response);
        }
    


    @GetMapping("/availability")
    public ResponseEntity<Object> getGasStationAvailability() {
        try {
            return ResponseEntity.ok(gasStationService.getGasStationAvailability());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching gas station availability: " + e.getMessage());
        }
    }

    // @PostMapping("/{id}/availability")
    // public ResponseEntity<String> updateAvailability(
    //         @PathVariable Integer id,
    //         @RequestBody AvailabilityRequest request) {
    //     try {
    //         gasStationService.upsertAvailability(id, request.getIdFuelType(), request.getIdStatus());
    //         return ResponseEntity.ok("Availability updated successfully");
    //     } catch (RuntimeException e) {
    //         if ("GasStation not found".equals(e.getMessage())) {
    //             return ResponseEntity.status(404).body(e.getMessage());
    //         } else if ("FuelType or Status not valid".equals(e.getMessage())) {
    //             return ResponseEntity.status(400).body(e.getMessage());
    //         }
    //         return ResponseEntity.status(500).body("Internal server error");
    //     }
    // }

}

