package asapshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/mainpage")
    public String homepage(Model model) {
        model.addAttribute("title", "Main page");
        return "mainpage";
    }

    @GetMapping("/products")
    public String productPage(Model model) {
        model.addAttribute("title", "Products");
        return "products-add";
    }

    @GetMapping("/cant-add-product")
    public String productAddErrorPage(Model model) {
        model.addAttribute("title", "Error");
        return "errors/cant-add-product";
    }


}
