package kg.alatoo.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

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

}
