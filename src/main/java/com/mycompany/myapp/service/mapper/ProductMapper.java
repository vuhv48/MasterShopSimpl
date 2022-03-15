package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { UserMapper.class, PictureMapper.class })
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "masterPic.id", target = "masterPicId")
    ProductDTO toDto(Product product);

    @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "updateTime", target = "updateTime", dateFormat = "yyyy-MM-dd hh:mm:ss")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "masterPicId", target = "masterPic.id")
    Product toEntity(ProductDTO productDTO);
}
