package kg.alatoo.springwebapp.repositories;

import kg.alatoo.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
