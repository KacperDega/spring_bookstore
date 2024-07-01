package com.example.springprojekt.controller;

import com.example.springprojekt.model.Book;
import com.example.springprojekt.repository.BookDAO;
import com.example.springprojekt.repository.IBookDAO;
import com.example.springprojekt.repository.OrderDAO;
import com.example.springprojekt.service.BookService;
import com.example.springprojekt.service.OrderService;
import com.example.springprojekt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping({"/home"})
    public String home(Model model) {
        model.addAttribute("orders", this.orderService.getByUser(this.userService.getCurrentUser()));
        return "home";
    }

    @RequestMapping(path = {"/main", "/"}, method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("books", this.bookService.getAll());
        return "main";
    }
}
