package asapshop.controller;

import asapshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginpage")
    public String homepage(Model model) {
        log.debug("Login page activated" + model);
        model.addAttribute("title", "Login page");
        return "loginpage";
    }

    @GetMapping("/profilepage")
    public String showUserProfile(Model model) {
        log.debug("ShowUserProfile page activated" + model);
        model.addAttribute("profile", userService.getAuthorizedUser());
        return "profilepage";
    }

    @PostMapping("/loginpage")
    public String login(Model model) {
        log.debug("Authorization process started" + model);
        model.addAttribute("profilepage", userService.getAuthorizedUser());
        return "redirect:/profilepage";
    }

    @GetMapping("/")
    public String loginRedirect(Model model) {
        return "redirect:/profilepage";
    }
}

