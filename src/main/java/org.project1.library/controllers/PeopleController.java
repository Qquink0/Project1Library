package org.project1.library.controllers;

import org.project1.library.dao.PersonDAO;
import org.project1.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person")Person person) {
        return "people/new";
    }

    @PostMapping(produces = "text/html; charset=UTF-8")
    public String create(@ModelAttribute("person")Person person) {
        personDAO.save(person);
        return "redirect:/people";
    }
}
