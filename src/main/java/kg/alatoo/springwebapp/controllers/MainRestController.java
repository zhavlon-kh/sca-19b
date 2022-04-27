package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class MainRestController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public MainRestController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String index() {
        return "Your server is working!";
    }

    @GetMapping("add-author") //localhost:8080/api/add-author
    public String addAuthor() {
        Author author = new Author("Kadyrmamat", "Momunov");
        authorRepository.save(author);
        return "Author added";
    }

    @GetMapping("authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("getAuthor/{id}")
    public Author getAuthor(@PathVariable("id") Long id) {
        return authorRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        System.out.println(id);
        authorRepository.deleteById(id);
        System.out.println(authorRepository.findAll());
    }
}
