package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.repository.OrderRepository;
import com.mycompany.myapp.service.IOrderService;
import com.mycompany.myapp.service.dto.OrderDTO;
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
    OrderMapper orderMapper;

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<OrderDTO> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
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
}
