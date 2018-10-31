package cy.ac.ucy.linc.microservices.books.controller;


import cy.ac.ucy.linc.microservices.books.dao.Book;
import cy.ac.ucy.linc.microservices.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/book/{pid}", produces = "application/json")
    public Book getBook(@PathVariable Long pid){
        return bookRepository.findBookById(pid);
    }
}
