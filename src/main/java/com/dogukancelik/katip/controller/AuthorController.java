package com.dogukancelik.katip.controller;

import com.dogukancelik.katip.exception.Conflict;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.service.AuthorService;
import com.dogukancelik.katip.service.BookService;
import com.dogukancelik.katip.service.PublisherService;
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
        if(author == null){
            throw new Conflict("Bu yazar nesnesi kaydedilemez -null object-");
        }

        try {
            authorService.saveAuthor(author);
        }catch (Exception e){
            throw new Conflict("Yazar nesnesi kaydedilemedi: " + e.getMessage());
        }

        this.author = authorService.createAuthor();
        return "/yazar-list.xhtml?faces-redirect=true";
    }
}
