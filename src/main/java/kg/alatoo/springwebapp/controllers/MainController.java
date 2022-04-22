package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping({"","index"})
    public String index(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Yntymak");
        names.add("Alina");
        names.add("Temirlan");
        names.add("Emir");
        names.add("Sulaiman");
        model.addAttribute("names",names);
        model.addAttribute("world", "main.world");
        return "main";
    }

    @GetMapping("about")
    public String about() {
        return "info";
    }

    @GetMapping("authors")
    public String authors(Model model) {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Sulaiman", "Yasirov"));
        authors.add(new Author("Islam", "Aubakirov"));
        authors.add(new Author("Islam", "Aubakirov"));
        authors.add(new Author("Islam", "Aubakirov"));
        model.addAttribute("authors",authorRepository.findAll());

        return "authors";
    }

}
