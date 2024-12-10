package bo.edu.usfa.gasolina.habragasolina.Service;

import bo.edu.usfa.gasolina.habragasolina.Entities.Status;
import bo.edu.usfa.gasolina.habragasolina.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Integer id) {
        return statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with ID: " + id));
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(Integer id, Status updatedStatus) {
        Status existingStatus = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found with ID: " + id));
        existingStatus.setNameStatus(updatedStatus.getNameStatus());
        existingStatus.setDescription(updatedStatus.getDescription());
        return statusRepository.save(existingStatus);
    }

    public void deleteStatus(Integer id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
        } else {
            throw new RuntimeException("Status not found with ID: " + id);
        }
    }
}
