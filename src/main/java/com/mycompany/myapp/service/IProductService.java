package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.ProductDTO;
import java.util.List;

public interface IProductService {
    List<ProductDTO> findAll();
}
