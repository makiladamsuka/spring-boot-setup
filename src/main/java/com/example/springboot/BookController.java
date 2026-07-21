package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books") // Adds /books prefix to all methods inside this controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // GET /books
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    // POST /books
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    // GET /books/{id}  (Now "index.html" won't match here!)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String bookDetails(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.findById(id).orElse(null));
        return "book-details";
    }

    // PUT /books/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable Long id, Book book) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/books";
    }

    // DELETE /books/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}