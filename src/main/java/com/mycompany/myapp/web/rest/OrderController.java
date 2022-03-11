package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.service.IOrderItemService;
import com.mycompany.myapp.service.IOrderService;
import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.service.dto.OrderDTO;
import com.mycompany.myapp.service.dto.OrderItemDTO;
import com.mycompany.myapp.service.impl.OrderServiceImpl;
import com.mycompany.myapp.service.util.Constants;
import com.mycompany.myapp.util.CartUtil;
import java.util.Date;
import java.util.List;
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
    IOrderItemService orderItemService;

    @Autowired
    UserService userService;

    @GetMapping("/orders")
    public List<OrderDTO> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/orderitems")
    public List<OrderItemDTO> findAllItem() {
        return orderItemService.findAll();
    }

    @RequestMapping(value = "/ordering", method = RequestMethod.POST)
    public String ordering(HttpSession session) {
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
            for (OrderItemDTO orderItemDTO : orderItemDTOs) {
                orderItemService.save(orderItemDTO);
            }
        } catch (NullPointerException ex) {
            System.out.println("Gio hang k co gi");
        }
        orderService.save(orderDTO);
        return "test ordering order controller";
    }

    @RequestMapping(value = "/orderitems/test", method = RequestMethod.POST)
    @ResponseBody
    public String addOrderItems(OrderItemDTO orderItemDTO) {
        System.out.println(orderItemDTO);
        orderItemService.save(orderItemDTO);
        return "add order items ok....";
    }
}
