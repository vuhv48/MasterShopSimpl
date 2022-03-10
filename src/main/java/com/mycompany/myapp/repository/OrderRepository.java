package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("from Order o where o.user.id = ?1")
    Page<Order> findByUserId(Long id, Pageable pageable);

    @Query("select count(o.id) from Order o where o.user.id=?1")
    long countByUserId(Long id);
}
