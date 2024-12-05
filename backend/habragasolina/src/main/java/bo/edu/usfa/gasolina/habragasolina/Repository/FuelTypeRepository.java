package bo.edu.usfa.gasolina.habragasolina.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bo.edu.usfa.gasolina.habragasolina.Entities.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository <FuelType, Integer> {
    FuelType findById(Integer Id);
}
