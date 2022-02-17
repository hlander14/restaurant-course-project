package by.overone.restaurant.controller;

import by.overone.restaurant.entity.ApplicationUser;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.entity.dto.DishDTO;
import by.overone.restaurant.service.impl.DishService;
import by.overone.restaurant.service.impl.OrderService;
import by.overone.restaurant.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/")
public class TemplateController {
    private List<DishDTO> dishesOfBasket = new ArrayList<>();

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishService dishService;

    @Autowired
    private MappingUtils mappingUtils;

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("index")
    public String getIndexPage(HttpSession session) {
        ApplicationUser user = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("basket_quantity", "0");
        return "index";
    }

    @GetMapping("menu")
    public String getMenuPage(Model model) {
        List<Dish> dishList = dishService.findAll();
        model.addAttribute("dishes", dishList);
        return "menu";
    }

    @GetMapping("addToBasket")
    public String addDishToBasket(@RequestParam(name = "menuId") Long menuId, HttpSession session) {
        Dish dish = dishService.findById(menuId);
        dishesOfBasket.add(mappingUtils.mapToDishDto(dish));
        session.setAttribute("basket_quantity", String.valueOf(dishesOfBasket.size()));
        return "redirect:/menu";
    }

    @GetMapping("basket")
    public String getBasket(Model model) {
        model.addAttribute("dishesOfBasket", dishesOfBasket);
        return "basket";
    }

    @GetMapping("removeFromBasket")
    public String removeDishFromBasket(@RequestParam(name = "menuId") Long menuId,
                                       HttpSession session) {
        DishDTO dish = null;
        try {
            dish = dishesOfBasket.stream()
                    .filter(dishInBasket -> dishInBasket.getId().equals(menuId))
                    .findFirst()
                    .orElseThrow(() -> new ClassNotFoundException("Dish with ID: " + menuId + " not found"));
        } catch (ClassNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        System.out.println(dish);
        System.out.println(dishesOfBasket.remove(dish));
        session.setAttribute("basket_quantity", String.valueOf(dishesOfBasket.size()));
        return "redirect:/basket";
    }

    @GetMapping("formAnOrder")
    public String formAnOrder(HttpSession session) {
        String username = (String) session.getAttribute("username");
        Long orderId = orderService.formAnOrder(username, dishesOfBasket);

        if (!orderId.equals(0L)){
            dishesOfBasket.clear();
            session.setAttribute("basket_quantity", 0);
            session.setAttribute("orderId", orderId);
            return "form_order/accepted";
        } else {
            return "form_order/rejected";
        }
    }

    @GetMapping("form_order/accepted")
    public String formOrderAccepted() {
        return "form_order/accepted";
    }

    @GetMapping("form_order/rejected")
    public String formOrderRejected() {
        return "form_order/rejected";
    }
}
