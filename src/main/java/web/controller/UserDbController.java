package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserDbController {
    final private UserService userService;
    @Autowired
    public UserDbController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers (Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "usersAll";
    }
    @DeleteMapping("/{id}/deleteUser")
    public String removeUser(@PathVariable("id") Long id){
        userService.removeUser(id);
        return "redirect:/";
    }
    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        return "addUser";
    }
    @PostMapping()
    public String addUserInDB(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getUserId(id));
        return "edit";
    }

    @PatchMapping("/updateUser")
    public String update (@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }
}
