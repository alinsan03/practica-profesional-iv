package bo.edu.usfa.gasolina.habragasolina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bo.edu.usfa.gasolina.habragasolina.Entities.GasStationEntity;
import bo.edu.usfa.gasolina.habragasolina.Service.GasStationService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/gasstation")
public class GasStationController {

    private final GasStationService gasStationService;

    @Autowired
    public GasStationController(GasStationService gasStationService) {
        this.gasStationService = gasStationService;
    }

    @PostMapping("/gasstation")
    public ResponseEntity<GasStationEntity> saveGasStation(@RequestBody GasStationEntity gasStation) {
        GasStationEntity newGasStation = gasStationService.saveGasStation(gasStation);
        return ResponseEntity.ok(newGasStation);
    }

    @GetMapping("/gasstation")
    public List<GasStationEntity> getAllGasStation() {
        return gasStationService.getAllGasStation();
    }

    @GetMapping("/gasstation/{id_gas_station}")
    public ResponseEntity<GasStationEntity> getGasStationById(@PathVariable Long id_gas_station) {
        Optional<GasStationEntity> gasStation = gasStationService.getGasStationById(id_gas_station);
        return gasStation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
