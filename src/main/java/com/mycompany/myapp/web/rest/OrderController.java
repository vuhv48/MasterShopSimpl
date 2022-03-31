package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.service.IOrderItemService;
import com.mycompany.myapp.service.IOrderService;
import com.mycompany.myapp.service.IProductService;
import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.service.dto.OrderDTO;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.impl.OrderServiceImpl;
import com.mycompany.myapp.service.util.Constants;
import com.mycompany.myapp.util.CartUtil;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @Autowired
    IProductService productService;

    @Autowired
    IOrderItemService orderItemService;

    @Autowired
    UserService userService;

    @GetMapping("/orders/test")
    public Boolean test() {
        System.out.println("test api ok...");
        return true;
    }

    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/orders/items")
    public List<OrderItemDTO> findAllItem() {
        return orderItemService.findAll();
    }

    @RequestMapping(value = "/orders/ordering", method = RequestMethod.POST)
    public boolean ordering(HttpSession session) {
        OrderDTO orderDTO = new OrderDTO();
        //orderDTO.setCreateTime(new Date().toString());
        User userCurrentLogin = userService.getUserWithAuthorities().get();
        if (userCurrentLogin != null) {
            orderDTO.setUserId(userCurrentLogin.getId());
        }
        orderDTO.setOrderNumber(new Date().toString());
        orderDTO.setStatus(Constants.OrderStatus.WAIT_PAY);

        try {
            List<OrderItemDTO> orderItemDTOs = CartUtil.getOrderItemFromCart(session);
            double totalSum = 0;
            for (int i = 0; i < orderItemDTOs.size(); i++) {
                totalSum += orderItemDTOs.get(i).getProductPrice() * orderItemDTOs.get(i).getQuantity();
            }
            orderDTO.setTotalPrice(totalSum);
            orderService.addOrderDTO(orderDTO, orderItemDTOs);
        } catch (NullPointerException ex) {
            return false;
        }
        CartUtil.cleanCart(session);
        return true;
    }

    @RequestMapping(value = "/orders/items/test", method = RequestMethod.POST)
    @ResponseBody
    public String addOrderItems(OrderItemDTO orderItemDTO) {
        System.out.println(orderItemDTO);

        //co the xu ly them ve gia : khuyen mai....
        Double price = productService.findById(orderItemDTO.getId()).getPrice() * orderItemDTO.getQuantity();
        orderItemDTO.setProductPrice(price);
        orderItemService.save(orderItemDTO);
        return "Ok";
    }

    @RequestMapping(value = "/orders/view/{id}", method = RequestMethod.GET)
    public OrderDTO orderView(@PathVariable Long id, HttpSession session) {
        return orderService.findById(id);
    }

    @RequestMapping(value = "/orders/itemview/{orderId}", method = RequestMethod.GET)
    public List<OrderItemDTO> orderItemView(@PathVariable Long orderId, HttpSession session) {
        return orderItemService.findByOrderItemId(orderId);
    }
}
