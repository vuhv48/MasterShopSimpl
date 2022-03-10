package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.OrderDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    OrderDTO save(OrderDTO orderDTO);
    Optional<OrderDTO> findById(Long id);
    List<OrderDTO> findAll();
    List<OrderDTO> findOrder(Pageable pageable);
    void deleteOrder(Long id);
    void updateOrderStatus(Long orderId, Integer status);
}
