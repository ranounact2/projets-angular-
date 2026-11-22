package .products.repository;

import .products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/** Spring Data JPA : fournit findAll, findById, deleteById, save... */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
