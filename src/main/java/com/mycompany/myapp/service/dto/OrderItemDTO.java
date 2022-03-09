package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDTO {

    private Long id;

    private String createTime;

    private String updateTime;

    private String orderNumber;
    private Long productId;
    private Long orderId;
}
