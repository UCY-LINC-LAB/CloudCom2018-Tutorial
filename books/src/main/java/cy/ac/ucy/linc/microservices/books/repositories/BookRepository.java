package cy.ac.ucy.linc.microservices.books.repositories;

import cy.ac.ucy.linc.microservices.books.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findBookById(Long id);
}
