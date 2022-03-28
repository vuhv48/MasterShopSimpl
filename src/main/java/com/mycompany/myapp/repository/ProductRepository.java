package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Optional<Product> findById(Long orderId);
}
