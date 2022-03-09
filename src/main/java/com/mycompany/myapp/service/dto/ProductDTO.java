package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String createTime;

    private String updateTime;

    private String title;

    private Long point;

    private String note;

    private String code;

    private String model;

    private Long stock;

    private Long userId;

    private Long masterPicId;
}
