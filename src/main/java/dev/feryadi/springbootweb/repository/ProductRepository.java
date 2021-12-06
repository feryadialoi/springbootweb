package dev.feryadi.springbootweb.repository;

import dev.feryadi.springbootweb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 10/8/2021 10:21 AM
 */
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
