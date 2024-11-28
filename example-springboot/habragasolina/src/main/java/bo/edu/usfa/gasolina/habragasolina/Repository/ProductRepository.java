package bo.edu.usfa.gasolina.habragasolina.Repository;

import bo.edu.usfa.gasolina.habragasolina.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByPrice(double price);
}