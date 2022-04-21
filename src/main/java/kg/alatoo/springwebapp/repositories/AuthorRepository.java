package kg.alatoo.springwebapp.repositories;

import kg.alatoo.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Override
    List<Author> findAll();
}
