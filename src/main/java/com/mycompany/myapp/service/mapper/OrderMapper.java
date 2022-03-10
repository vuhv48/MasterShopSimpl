package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Order;
import com.mycompany.myapp.service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "user.id", target = "userId")
    OrderDTO toDto(Order order);
}
