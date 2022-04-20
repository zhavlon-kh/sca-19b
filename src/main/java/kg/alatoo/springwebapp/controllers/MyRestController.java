package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class MyRestController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public MyRestController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("bye")
    public String goodBye() {
        return "Good Bye!";
    }



    @GetMapping("addbook")
    public String addBook() {
        Book databaseBook = new Book("Database", "125434754");
        System.out.println(databaseBook);
        bookRepository.save(databaseBook);
        System.out.println(databaseBook);

        return "Book added: " + databaseBook.toString();
    }

    @GetMapping("books")
    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("authors")
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

}
