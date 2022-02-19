package by.overone.restaurant.controller;

import by.overone.restaurant.entity.ApplicationUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("index")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("main")
    public String getMainPage(HttpSession session) {
        ApplicationUser user = (ApplicationUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("basket_quantity", "0");
        return "main";
    }
}
