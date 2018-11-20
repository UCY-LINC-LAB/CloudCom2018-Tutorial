package cy.ac.ucy.linc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@CrossOrigin
public class ProductController {

    @CrossOrigin
    @GetMapping("/products")
    public String products(Model model){
        return "products.html";
    }

    @CrossOrigin
    @GetMapping("/login")
    public String login(Model model){
        return "login.html";
    }

    @CrossOrigin
    @GetMapping("/products/product/{pid}")
    public String getSpecificProduct(Model model, @PathVariable int pid){
        model.addAttribute("pid", pid);
        return "product.html";
    }
}
