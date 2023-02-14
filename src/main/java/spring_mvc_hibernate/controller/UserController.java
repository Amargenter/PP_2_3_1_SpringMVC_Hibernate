package spring_mvc_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_mvc_hibernate.model.User;
import spring_mvc_hibernate.service.UserService;

import java.util.List;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user) {

        userService.add(user);

        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userID") Integer id,
                             Model model) {

        User user = userService.getById(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userID") Integer id) {

        userService.delete(id);

        return "redirect:/";
    }
}
