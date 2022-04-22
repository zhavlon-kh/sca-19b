package kg.alatoo.springwebapp.bootstrap;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component("startData")
public class StartData implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public StartData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book database = new Book("Database", "15345324");
        Author author = new Author("Islam","Aubakirov");
        Author author2 = new Author("Alina","Pinazarova");

        author.getBooks().add(database);
        author2.getBooks().add(database);

        database.getAuthors().add(author);
        database.getAuthors().add(author2);

        authorRepository.save(author);
        authorRepository.save(author2);
        bookRepository.save(database);
    }
}
