package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.IOrderItemService;
import com.mycompany.myapp.service.IOrderService;
import com.mycompany.myapp.service.dto.OrderDTO;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.impl.OrderServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IOrderItemService orderItemService;

    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/orderitems")
    public List<OrderItemDTO> findAllItem() {
        return orderItemService.findAll();
    }
}
