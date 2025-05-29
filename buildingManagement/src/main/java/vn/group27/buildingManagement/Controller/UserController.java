package vn.group27.buildingManagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService us){
        this.userService=us;
    }

    @GetMapping("/UserList")
    public String UserManagement(Model model){
        List<User> userList=userService.findAll();
        model.addAttribute("userList", userList);
        return "UserManament";
    }
//    @GetMapping("/UserList")
//    public List<User> UserManagement(Model model){
//        return userService.findAll();
//    }
}
