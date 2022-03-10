package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.OrderItemDTO;
import java.util.List;

public interface IOrderItemService {
    List<OrderItemDTO> findAll();
}
