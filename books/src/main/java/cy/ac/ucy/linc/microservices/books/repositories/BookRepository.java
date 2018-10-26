package cy.ac.ucy.linc.microservices.books.repositories;

import cy.ac.ucy.linc.microservices.books.dao.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}