package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Book;
import kg.alatoo.springwebapp.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final Logger LOG = LoggerFactory.getLogger(MainController.class);

    private final BookRepository bookRepository;

    public MainController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("add")
    public String addBookForm() {
        return "bookaddform";
    }

    @PostMapping("addbook")
    public String addBook(
            @RequestParam(name = "name")String name,
            @RequestParam(name = "isbn") String isbn
    ) {
        Book databaseBook = new Book(name, isbn);
        bookRepository.save(databaseBook);
        LOG.info("Saved book: " + databaseBook.toString());
        return "redirect:/api/books";
    }
}
