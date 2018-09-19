package cy.ac.ucy.linc.repositories;

import cy.ac.ucy.linc.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
