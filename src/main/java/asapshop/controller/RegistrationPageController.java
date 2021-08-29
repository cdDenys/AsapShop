package asapshop.controller;

import asapshop.entity.User;
import asapshop.repository.UserRepository;
import asapshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationPageController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("title", "Registration page");
        return "registration";
    }

    @GetMapping("/cant-add-user")
    public String errorRegisterUSer(Model model) {
        model.addAttribute("title", "Error page");
        return "errors/cant-add-user";
    }

    @PostMapping("registration")
    public String singUpUser(@RequestParam String name, @RequestParam String surname,
                             @RequestParam String login, @RequestParam String password){
        User user = new User(name, surname, login, password);
        if (name.isEmpty() && surname.isEmpty() && login.isEmpty() && password.isEmpty()){
            return "redirect:/cant-add-user";
        }else{
            userService.createUser(user);
         return "redirect:/mainpage";
        }
    }

}
