package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDTO {

    private Long id;

    private String createTime;

    private String updateTime;

    private String orderNumber;

    private String address;

    private String phone;

    private String zipcode;

    private String consignee;

    private String payTime;

    private String shipTime;

    private Integer status;

    private Double finalPrice;

    private Double totalPrice;

    private Long userId;
}
