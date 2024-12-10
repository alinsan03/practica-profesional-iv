package bo.edu.usfa.gasolina.habragasolina.Controllers;

import bo.edu.usfa.gasolina.habragasolina.Entities.Status;
import bo.edu.usfa.gasolina.habragasolina.Service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("")
    public ResponseEntity<List<Status>> getAllStatuses() {
        List<Status> statuses = statusService.getAllStatuses();
        return ResponseEntity.ok(statuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable Integer id) {
        try {
            Status status = statusService.getStatusById(id);
            return ResponseEntity.ok(status);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<Status> createStatus(@RequestBody Status status) {
        Status newStatus = statusService.createStatus(status);
        return ResponseEntity.ok(newStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Status status) {
        try {
            Status updatedStatus = statusService.updateStatus(id, status);
            return ResponseEntity.ok(updatedStatus);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStatus(@PathVariable Integer id) {
        try {
            statusService.deleteStatus(id);
            return ResponseEntity.ok("Status deleted successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
