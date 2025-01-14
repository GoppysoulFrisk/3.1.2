package com.example.kata.controller;

import com.example.kata.models.User;
import com.example.kata.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("users")
public class UserController {
    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsersPage(Model model) {
        model.addAttribute("users", userService.getThemAll());
        model.addAttribute("newUser", new User());
        return "users/index";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        System.out.println("saving user " + user);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        if (id > 0) {
            userService.delete(id);
        }
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String getUpdatePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getThemById(id));
        return "users/update";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }
}