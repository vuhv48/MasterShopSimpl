package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.repository.ProductRepository;
import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.dto.ProductDTO;
import com.mycompany.myapp.service.mapper.ProductMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::toDto).collect(Collectors.toList());
        //return null;
    }
}
