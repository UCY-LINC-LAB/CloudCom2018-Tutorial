package cy.ac.ucy.linc.microservices.books.controller;


import cy.ac.ucy.linc.microservices.books.dao.Book;
import cy.ac.ucy.linc.microservices.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
