package com.mycompany.myapp.util;

import com.mycompany.myapp.domain.OrderItem;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.dto.ProductDTO;
import com.mycompany.myapp.service.util.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

public class CartUtil {

    public static final String CART = Constants.CART;

    public static void saveProductToCart(HttpSession session, ProductDTO productDTO, Integer total) {
        Map<Long, CartItem> cartItemMap = (HashMap<Long, CartItem>) session.getAttribute(CART);
        CartItem ci = new CartItem(productDTO, total);
        if (cartItemMap == null) {
            cartItemMap = new HashMap<Long, CartItem>();
        }
        if (cartItemMap.containsKey(productDTO.getId())) {
            CartItem currentCi = cartItemMap.get(productDTO.getId());
            currentCi.setTotal(currentCi.getTotal() + total);
            cartItemMap.put(productDTO.getId(), currentCi);
        } else {
            cartItemMap.put(productDTO.getId(), ci);
        }
        session.setAttribute(CART, cartItemMap);
    }

    public static synchronized void deleteProductFromCart(HttpSession session, Long productDtoId) {
        Map<Long, CartItem> cartItemMap = (HashMap<Long, CartItem>) session.getAttribute(CART);
        if (cartItemMap != null) {
            cartItemMap.remove(productDtoId);
        }
        session.setAttribute(CART, cartItemMap);
    }

    public static synchronized void cleanCart(HttpSession session) {
        Map<Long, CartItem> cartItemMap = (HashMap<Long, CartItem>) session.getAttribute(CART);
        if (cartItemMap != null) {
            cartItemMap.clear();
        }
        session.setAttribute(CART, cartItemMap);
    }

    public static List<OrderItemDTO> getOrderItemFromCart(HttpSession session) {
        Map<Long, CartItem> cartItemMap = (HashMap<Long, CartItem>) session.getAttribute(CART);

        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        for (CartItem ci : cartItemMap.values()) {
            OrderItemDTO oi = new OrderItemDTO();
            oi.setProductId(ci.getProductDTO().getId());
            oi.setQuantity(ci.getTotal());
            orderItemDTOs.add(oi);
        }
        return orderItemDTOs;
    }

    public static Map<Long, CartItem> getAllCartItem(HttpSession session) {
        Map<Long, CartItem> cartItemMap = (HashMap<Long, CartItem>) session.getAttribute(CART);
        return cartItemMap;
    }
}
