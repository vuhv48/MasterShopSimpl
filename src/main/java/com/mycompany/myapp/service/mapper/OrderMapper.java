package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Order;
import com.mycompany.myapp.service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Mapping(target = "orderItems", ignore = true)
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "payTime", target = "payTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "shipTime", target = "shipTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "payTime", target = "payTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "shipTime", target = "shipTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    OrderDTO toDto(Order order);
}
