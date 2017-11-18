package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String users(Model model) {

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "/users/user.html";
    }

    @GetMapping(value = "/add")
    public String showAdduserForm(Model model) {
        User newUser = new User();

        model.addAttribute("user", newUser);

        return "/users/user_add.html";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User newUser) {
        userService.saveUser(newUser);

        return "redirect:/user";
    }


}
