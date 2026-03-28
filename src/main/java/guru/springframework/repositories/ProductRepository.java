package guru.springframework.repositories;

import guru.springframework.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}