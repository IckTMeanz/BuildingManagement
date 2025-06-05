package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.group27.buildingManagement.Entity.Role;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/default")
public class DefaultController {
    @Autowired
    private UserService userService;
    @GetMapping("/ho-nhankhau")

    public String getHNKhau(){
        return "ho-nhankhau";
    }

    @GetMapping("/users")
    public String getUser(){
        return "users";
    }

    @GetMapping("/thongke")
    public String thongke(){
        return "thongke";
    }

    @GetMapping("/user/profile")
    public String showProfile(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);

        model.addAttribute("username", user.getUsername());
        //model.addAttribute("email", user.getEmail());
        Role role = user.getRoles().stream().findFirst().orElse(null);

        model.addAttribute("role", role.getName());
        return "profile";
    }


}
