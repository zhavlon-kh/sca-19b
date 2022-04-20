package kg.alatoo.springwebapp.bootstrap;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class InitData implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public InitData(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Spring Framework", "5434354135");
        Author author = new Author("Almambet", "Totoev");

        book.getAuthors().add(author);
        author.getBooks().add(book);

        bookRepository.save(book);
        authorRepository.save(author);
    }
}
