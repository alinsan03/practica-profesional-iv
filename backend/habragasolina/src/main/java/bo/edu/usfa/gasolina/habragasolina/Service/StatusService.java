package bo.edu.usfa.gasolina.habragasolina.Service;

import java.util.List;

import org.springframework.stereotype.Service;


import bo.edu.usfa.gasolina.habragasolina.Entities.Status;
import bo.edu.usfa.gasolina.habragasolina.Repository.StatusRepository;




@Service
public class StatusService {

        private final StatusRepository statusRepository;

        public StatusService(StatusRepository statusRepository) {
            this.statusRepository = statusRepository;
        }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

}
