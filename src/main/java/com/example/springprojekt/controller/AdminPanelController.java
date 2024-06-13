package com.example.springprojekt.controller;

import com.example.springprojekt.model.Order;
import com.example.springprojekt.model.OrderStatus;
import com.example.springprojekt.service.BookService;
import com.example.springprojekt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class
AdminPanelController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BookService bookService;

    @GetMapping("/admin/adminpanel")
    public String adminpanel(Model model) {
        model.addAttribute("books",this.bookService.getAll());
        model.addAttribute("orders", this.orderService.getAll());
        return "adminpanel";
    }
}
