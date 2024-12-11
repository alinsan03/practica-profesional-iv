package bo.edu.usfa.gasolina.habragasolina.Controllers;

import bo.edu.usfa.gasolina.habragasolina.Entities.Availability;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStation;
import bo.edu.usfa.gasolina.habragasolina.Request.AvailabilityRequest;
import bo.edu.usfa.gasolina.habragasolina.Service.GasStationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("gasstation")
public class GasStationController {

    private final GasStationService gasStationService;

    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @PostMapping("")
    public ResponseEntity<GasStation> saveGasStation(@Valid @RequestBody GasStation gasStation) {
        GasStation newGasStation = gasStationService.saveGasStation(gasStation);
        return ResponseEntity.status(201).body(newGasStation); // 201 Created
    }


    @PutMapping("/{id}")
    public ResponseEntity<GasStation> updateGasStation(@PathVariable Integer id, @Valid @RequestBody GasStation gasStation) {
        GasStation updatedGasStation = gasStationService.updateGasStation(id, gasStation);
        return ResponseEntity.ok(updatedGasStation);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGasStation(@PathVariable Integer id) {
        try {
            gasStationService.deleteGasStation(id);
            return ResponseEntity.ok("Estación de gas eliminada exitosamente.");
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
            return ResponseEntity.status(500).body("Error al obtener la disponibilidad de la gasolinera: " + e.getMessage());
        }
    }

    @PostMapping("/{id}/availability")
    public ResponseEntity<String> upsertAvailability( @PathVariable Integer id, @RequestBody AvailabilityRequest request) {
        try {
            gasStationService.upsertAvailability(id, request.getIdFuelType(), request.getIdStatus());
            return ResponseEntity.ok("Availability updated successfully");
        } catch (RuntimeException e) {
            if ("GasStation not found".equals(e.getMessage())) {
                return ResponseEntity.status(404).body(e.getMessage());
            } else if ("FuelType or Status not valid".equals(e.getMessage())) {
                return ResponseEntity.status(400).body(e.getMessage());
            }
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}

