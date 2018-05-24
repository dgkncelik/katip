package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.service.AuthorService;
import com.dogukancelik.kutuphane.service.BookService;
import com.dogukancelik.kutuphane.service.PublisherService;
import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope(value = "session")
@Component(value = "authorController")
@ELBeanName(value = "authorController")
@Join(path = "/yazar-form", to = "/yazar-form.jsf")
public class AuthorController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private Author author;

    @Autowired
    public AuthorController(BookService bookService,
                            PublisherService publisherService,
                            AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.author = authorService.createAuthor();
    }

    public String save(){
        authorService.saveAuthor(author);
        this.author = authorService.createAuthor();
        return "/yazar-list.xhtml?faces-redirect=true";
    }

}
