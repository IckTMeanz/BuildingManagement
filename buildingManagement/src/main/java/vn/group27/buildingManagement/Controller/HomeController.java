package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.group27.buildingManagement.Entity.KhoanThu;
import vn.group27.buildingManagement.Entity.Role;
import vn.group27.buildingManagement.Entity.User;
import vn.group27.buildingManagement.Repo.RoleRepo;
import vn.group27.buildingManagement.Repo.UserRepo;

@Controller
@RequestMapping("/Bluemoon")
public class HomeController {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private RoleRepo roleRepo;
    @Autowired
    public HomeController(UserRepo userRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo){
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
        this.roleRepo=roleRepo;
    }

    @GetMapping("/home")
    public String home(){
        return "home1";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();  // lấy username
        model.addAttribute("username", username);

        return "dashboard";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        User new_user= new User();
        model.addAttribute("new_user", new_user);
        return "signUp";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user) {
        // Mã hóa mật khẩu trước khi lưu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.getRoles().add(this.roleRepo.findByName("ROLE_USER")); // hoặc ADMIN/KETOAN tùy bạn

        userRepo.save(user);

        return "redirect:/Bluemoon/login"; // hoặc dashboard
    }
}
