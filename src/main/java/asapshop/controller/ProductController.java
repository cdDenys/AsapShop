package asapshop.controller;

import asapshop.entity.Product;
import asapshop.repository.ProductRepository;
import asapshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products-list")
    public String showAllProducts(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products-list";
    }

    @PostMapping("/products-add")
    public String addProduct(@RequestParam String productName,
                             @RequestParam String productDescription,
                             @RequestParam BigDecimal productPrice) {

        Product product = new Product(productName, productDescription, productPrice);
        if (productName.isEmpty() || productDescription.isEmpty() || productPrice.equals(BigDecimal.ZERO)) {
            return "redirect:/cant-add-product";
        } else {
            productService.createProduct(product);
            return "redirect:/products-list";
        }
    }

    @GetMapping("/edit-products")
    public String editProducts(Model model) {
        Iterable<Product> productsEdit = productRepository.findAll();
        model.addAttribute("products-edit", productsEdit);
        return "edit-products";
    }
}
