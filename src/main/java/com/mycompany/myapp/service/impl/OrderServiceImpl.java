package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Order;
import com.mycompany.myapp.domain.OrderItem;
import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.repository.OrderItemRepository;
import com.mycompany.myapp.repository.OrderRepository;
import com.mycompany.myapp.service.IOrderService;
import com.mycompany.myapp.service.dto.OrderDTO;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.mapper.OrderItemMapper;
import com.mycompany.myapp.service.mapper.OrderMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemMapper orderItemMapper;

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order = orderRepository.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.get() == null) {
            return null;
        }
        return orderMapper.toDto(order.get());
    }

    @Override
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> findOrder(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateOrderStatus(Long orderId, Integer status) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addOrderDTO(OrderDTO orderDTO, List<OrderItemDTO> orderItemDTOs) {
        OrderDTO orderDTOWithId = save(orderDTO);
        for (OrderItemDTO orderItemDTO : orderItemDTOs) {
            orderItemDTO.setOrderId(orderDTOWithId.getId());
            OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
            orderItemRepository.save(orderItem);
        }
    }
}
