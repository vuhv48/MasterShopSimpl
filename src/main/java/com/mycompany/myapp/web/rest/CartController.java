package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.dto.ProductDTO;
import com.mycompany.myapp.service.util.Constants;
import com.mycompany.myapp.util.CartItem;
import com.mycompany.myapp.util.CartUtil;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    IProductService productService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public Map<Long, CartItem> cart(HttpSession session) {
        return CartUtil.getAllCartItem(session);
    }

    @RequestMapping(value = "/cart/addToCart", method = RequestMethod.POST)
    @ResponseBody
    public OrderItemDTO addToCart(@RequestParam Long id, @RequestParam Integer total, HttpSession session) {
        ProductDTO productDTO = productService.findById(id);
        CartUtil.saveProductToCart(session, productDTO, total);
        System.out.println("-------------");
        CartUtil.getOrderItemFromCart(session).stream().forEach(o1 -> System.out.println(o1));
        System.out.println("-------------");

        return CartUtil.getOrderItemFromCart(session).stream().filter(o1 -> (o1.getProductId().equals(id))).findAny().orElse(null);
    }

    @RequestMapping(value = "/cart/deleteAll", method = RequestMethod.DELETE)
    public boolean deleteAllFromCart(HttpSession session) {
        CartUtil.cleanCart(session);
        if (CartUtil.getAllCartItem(session) == null) {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/cart/delete/{productDtoId}", method = RequestMethod.DELETE)
    public Long deleteFromCart(@PathVariable Long productDtoId, HttpSession session) {
        CartUtil.deleteProductFromCart(session, productDtoId);
        return productDtoId;
    }
}
