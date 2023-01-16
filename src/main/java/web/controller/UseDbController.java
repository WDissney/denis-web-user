package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImpl;

@Controller
public class UseDbController {
    final private UserServiceImpl userServiceImpl;
    @Autowired
    public UseDbController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String showUsers (Model model){
        model.addAttribute("users", userServiceImpl.getAllUsers());
        return "usersAll";
    }
    @DeleteMapping("/{id}/deleteUser")
    public String removeUser(@PathVariable("id") Long id){
        userServiceImpl.removeUser(id);
        return "redirect:/";
    }
    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        return "addUser";
    }
    @PostMapping()
    public String addUserInDB(@ModelAttribute("user") User user){
        userServiceImpl.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userServiceImpl.getUserId(id));
        return "edit";
    }

    @PatchMapping("/updateUser")
    public String update (@ModelAttribute("user") User user){
        userServiceImpl.updateUser(user);
        return "redirect:/";
    }
}
