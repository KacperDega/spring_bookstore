package com.example.springprojekt.controller;

import com.example.springprojekt.model.Order;
import com.example.springprojekt.model.OrderStatus;
import com.example.springprojekt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/submit")
    public String submitOrder() {
        Order order = orderService.submitOrder();
        return "redirect:/order/" + order.getId();
    }

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable Long
                                   orderId, Model model) {
        Order order =
                orderService.getOrder(orderId);
        model.addAttribute("order", order);
        return "order";
    }

    @PostMapping("/{orderId}/changeStatus")
    public String changeStatus(@PathVariable Long orderId, @RequestParam OrderStatus orderStatus) {
        Order order = orderService.getOrder(orderId);
        order.setStatus(orderStatus);
        orderService.saveOrder(order);
        return "redirect:/order/" + orderId;
    }
}
