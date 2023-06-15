package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = { "/login", "/" })
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "user/register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user/register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/user/list")
    public String listRegisteredUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("userList", users);
        return "user/user_list";
    }

    @GetMapping(value = { "user/detail", "user/detail/", "user/detail/{id}" })
    public String detailUser(@PathVariable(value = "id", required = false) Long id, Model model) {
        User user = new User();
        if (id != null) {
            user = userService.findOneUser(id);
        }
        model.addAttribute("user", user);
        return "user/user_form";
    }

    @PostMapping(value = "user/detail", params = "create")
    public String createUser(@ModelAttribute("user") UserDto user, Model model) {
        userService.saveUser(user);
        model.addAttribute("message", "Provider created successfully");
        return "redirect:/user/list";
    }


    @PostMapping(value = "user/detail", params = "update")
    public String updateUser(@ModelAttribute("user") User user, Model model) {
        userService.updateOneUser(user);
        model.addAttribute("message", "Provider updated successfully");
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteOneUser(id);
        return "redirect:/user/list";
    }
}