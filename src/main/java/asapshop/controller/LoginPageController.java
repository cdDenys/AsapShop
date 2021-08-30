package asapshop.controller;

import asapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginPageController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginpage")
    public String homepage(Model model) {
        model.addAttribute("title", "Login page");
        return "loginpage";
    }

    @PostMapping("/loginpage")
    public String login(Model model) {
        model.addAttribute("loginpage", userService.getAuthorizedUser());
        return "redirect:profilepage";
    }

    @GetMapping("/profilepage")
    public String showUserProfile(Model model) {
        model.addAttribute("profile", userService.getAuthorizedUser());
        return "profilepage";
    }
}
