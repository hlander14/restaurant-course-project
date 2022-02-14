package by.overone.restaurant.controller;

import by.overone.restaurant.auth.ApplicationUser;
import by.overone.restaurant.entity.Dish;
import by.overone.restaurant.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class TemplateController {

    @Autowired
    private DishService dishService;

    @GetMapping("index")
    public String getIndexPage(HttpSession session) {
        ApplicationUser user = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("basket_quantity", "0");
        return "index";
    }

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("menu")
    public String getMenuPage(Model model) {
        List<Dish> dishList = dishService.findAll();
        model.addAttribute("dishes", dishList);
        return "menu";
    }
}
