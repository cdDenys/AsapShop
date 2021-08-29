package asapshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {
    @GetMapping("/loginpage")
    public String homepage(Model model) {
        model.addAttribute("title", "Login page");
        return "loginpage";
    }
}
