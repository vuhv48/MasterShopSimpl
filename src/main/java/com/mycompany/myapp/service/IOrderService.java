package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.OrderDTO;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface IOrderService {
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO findById(Long id);
    List<OrderDTO> findAll();
    List<OrderDTO> findOrder(Pageable pageable);
    void deleteOrder(Long id);
    void updateOrderStatus(Long orderId, Integer status);

    void addOrderDTO(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOs);
}
