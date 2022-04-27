package kg.alatoo.springwebapp.controllers;

import kg.alatoo.springwebapp.domain.Author;
import kg.alatoo.springwebapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String authors(@ModelAttribute(name = "addedAuthor") Author addedAuthor,
            Model model) {
        /*List<Author> authors = new ArrayList<>();
        authors.add(new Author("Sulaiman", "Yasirov"));
        authors.add(new Author("Islam", "Aubakirov"));
        authors.add(new Author("Islam", "Aubakirov"));
        authors.add(new Author("Islam", "Aubakirov"));*/
        System.out.println(addedAuthor);
        model.addAttribute("authors",authorRepository.findAll());
        model.addAttribute("newAuthor", new Author());

        return "authors";
    }

    @PostMapping("addauthor")
    public String addAuthor(
            @RequestBody MultiValueMap<String, String> requestBody,
            @ModelAttribute Author author,
            RedirectAttributes redirectAttributes
    ) {
        /*System.out.println(requestBody.entrySet());
        Author author = new Author();
        author.setFirstName(requestBody.getFirst("firstName"));
        author.setLastName(requestBody.getFirst("lastName"));*/
        System.out.println(requestBody);
        System.out.println(author);
        authorRepository.save(author);
        redirectAttributes.addAttribute("addedAuthor", author);
        return "redirect:authors";
    }

    @GetMapping("editAuthor/{id}")
    public String editAuthor(@PathVariable Long id,Model model) {
        Optional<Author> editAuthor = authorRepository.findById(id);
        model.addAttribute("editAuthor",editAuthor);
        return "forms";
    }
}
