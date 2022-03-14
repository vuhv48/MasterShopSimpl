package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.OrderItem;
import com.mycompany.myapp.repository.OrderItemRepository;
import com.mycompany.myapp.repository.OrderRepository;
import com.mycompany.myapp.service.IOrderItemService;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.mapper.OrderItemMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderItemMapper orderItemMapper;

    public List<OrderItemDTO> findAll() {
        return orderItemRepository.findAll().stream().map(orderItemMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrderItemDTO save(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemMapper.toEntity(orderItemDTO);
        orderItem = orderItemRepository.save(orderItem);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    public List<OrderItemDTO> findByOrderItemId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId).stream().map(orderItemMapper::toDto).collect(Collectors.toList());
    }
}
