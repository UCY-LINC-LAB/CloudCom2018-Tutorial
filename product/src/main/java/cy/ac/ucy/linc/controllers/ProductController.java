package cy.ac.ucy.linc.controllers;

import cy.ac.ucy.linc.repositories.BookRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Api
public class ProductController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "products.html";
    }
}
