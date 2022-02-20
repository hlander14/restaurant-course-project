package by.overone.restaurant.controller;

import by.overone.restaurant.entity.Order;
import by.overone.restaurant.entity.User;
import by.overone.restaurant.entity.enums.OrderStatus;
import by.overone.restaurant.service.impl.OrderService;
import by.overone.restaurant.service.impl.UserService;
import by.overone.restaurant.utils.impl.UserMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMappingUtils userMappingUtils;

    @GetMapping("work_panel")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    public String workPanel() {
        return "work_panel/work_panel";
    }

    @GetMapping("view_orders")
    @PreAuthorize("hasAnyAuthority('admin:read', 'admin:write')")
    public String viewAllOrders(Model model) {
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orders", orderList);
        return "work_panel/view_orders";
    }

    @GetMapping("order_to_confirm")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    public String confirmOrderToConfirm(Model model) {
        List<Order> orderList = orderService.findAll();
        model.addAttribute("orders", orderList.stream()
                .filter(d -> d.getStatus().equals(OrderStatus.VERIFICATION))
                .collect(Collectors.toList()));
        return "work_panel/order_to_confirm";
    }

    @GetMapping("confirm_order")
    public String confirmOrder(@RequestParam(name = "orderId") Long orderId) {
        Order order = orderService.findById(orderId);
        order.setStatus(OrderStatus.CONFIRMED);
        orderService.create(order);
        return "work_panel/order_to_confirm";
    }

    @GetMapping("replenishment_balance")
    public String replenishmentBalance(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("users", userList.stream()
                .map(user -> userMappingUtils.mapToDto(user))
                .collect(Collectors.toList()));
        return "work_panel/replenishment_balance";
    }


}
