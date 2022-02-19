package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.service.impl.OrderService;
import by.overone.restaurant.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @GetMapping("orders")
    public String getMenuPage(Model model, HttpSession session) {
        List<User> users = userService.findAll();
        String username = (String) session.getAttribute("username");


        List<Order> orderList = userService.findOrdersByUsername(username);
        model.addAttribute("orders", orderList);
        return "orders";
    }

    @GetMapping("paidOrder")
    public String paidOrder(@RequestParam(name = "orderId") Long orderId, HttpSession session) {
        orderService.paidOrder(orderId, (String) session.getAttribute("username"));
        return "orders";
    }
}
