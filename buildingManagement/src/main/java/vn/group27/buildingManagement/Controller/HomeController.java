package vn.group27.buildingManagement.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Bluemoon")
public class HomeController {

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
}
