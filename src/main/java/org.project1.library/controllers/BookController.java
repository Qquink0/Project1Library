package org.project1.library.controllers;

import org.project1.library.dao.BookDAO;
import org.project1.library.dao.PersonDAO;
import org.project1.library.models.Book;
import org.project1.library.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;
    private final PersonDAO personDAO;

    @Autowired
    public BookController(BookDAO bookDAO, PersonDAO personDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "books/new";
    }

    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/new";
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, @PathVariable("id") int id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "books/edit";
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));

        model.addAttribute("personWithBook", bookDAO.join(id));

        model.addAttribute("people", personDAO.index());
        model.addAttribute("person", new Person());

        return "books/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/set")
    public String set(@PathVariable("id") int id, @ModelAttribute("person") Person person) {
        bookDAO.set(id, person);
        return "redirect:/books/{id}";
    }

    @PatchMapping("/{id}/clear")
    public String clear(@PathVariable("id") int id) {
        bookDAO.clear(id);
        return "redirect:/books/{id}";
    }
}
