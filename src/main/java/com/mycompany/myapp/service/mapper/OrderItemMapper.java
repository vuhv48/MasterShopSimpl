package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.OrderItem;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class, ProductMapper.class, OrderMapper.class })
public interface OrderItemMapper extends EntityMapper<OrderItemDTO, OrderItem> {
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    OrderItemDTO toDto(OrderItem orderItem);

    @Mapping(source = "orderId", target = "order.id")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    OrderItem toEntity(OrderItemDTO orderItemDTO);
}
