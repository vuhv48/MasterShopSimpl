package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Product;
import com.mycompany.myapp.service.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class, PictureMapper.class })
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
