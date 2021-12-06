package dev.feryadi.springbootweb.controller;

import dev.feryadi.springbootweb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author Feryadialoi
 * @date 10/8/2021 1:31 AM
 */
@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String index(Model model) {
        User user = new User("Feryadi", 25, "male");

        String name = Optional.of(user).map(User::getName).orElse("Feryadi");

        model.addAttribute("user", user);
        model.addAttribute("name", "Feryadi");
        model.addAttribute("age", "25");
        model.addAttribute("gender", "male");
        model.addAttribute("names", new String[]{
                "Feryadi",
                "Aloi",
                "Feryadialoi"
        });
        return "index";
    }

}
