package bo.edu.usfa.gasolina.habragasolina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bo.edu.usfa.gasolina.habragasolina.Entities.Status;



public interface StatusRepository extends JpaRepository <Status , Integer> {
    
}