package com.mycompany.myapp.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PictureDTO {

    private Long id;

    private String createTime;

    private String updateTime;

    private String title;

    private String url;
}
