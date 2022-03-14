package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    void deleteByOrderId(Long orderId);
    List<OrderItem> findByOrderId(Long orderId);
}
