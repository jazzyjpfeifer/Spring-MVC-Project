package app.controller;

import app.entity.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String users(Model model) {

        List<User> users = userService.getUsers();

        model.addAttribute("users", users);

        return "users/users.html";
    }

    @GetMapping(value = "/add")
    public String showAdduserForm(Model model) {
        User newUser = new User();

        model.addAttribute("user", newUser);

        return "/users/user_add.html";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {

        // save the customer using our service
        userService.saveUser(user);

        return "redirect:/users.html";
    }

}
