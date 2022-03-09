package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.dto.ProductDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/product/test")
    public String findAllTest() {
        return "test controller findAllTest ok....";
    }

    @GetMapping("/products")
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }
}
