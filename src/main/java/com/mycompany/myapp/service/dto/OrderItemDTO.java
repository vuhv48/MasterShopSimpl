package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemDTO {

    private Long id;
    private Integer quantity;
    private Long productId;
    private Double productPrice;
    private Long orderId;
}
