package com.mycompany.myapp.util;

import com.mycompany.myapp.service.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private ProductDTO productDTO;
    private Integer total;
}
