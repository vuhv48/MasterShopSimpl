package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItemDTO {

    private Long id;
    private String createTime;
    private String updateTime;
    private Long productId;
    private Long orderId;
    private Integer quantity;
}
