package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.service.AuthorService;
import com.dogukancelik.kutuphane.service.BookService;
import com.dogukancelik.kutuphane.service.PublisherService;
import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Scope(value = "session")
@Component(value = "authorEditController")
@ELBeanName(value = "authorEditController")
@Join(path = "/yazar-edit", to = "/yazar-edit.jsf")
public class AuthorEditController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private Author author;

    @Autowired

    public AuthorEditController(BookService bookService,
                                PublisherService publisherService,
                                AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;


    }

    @GetMapping
    public void yazar(@RequestParam(value = "id") Long id){
        System.out.println(id);

    }

    public String updateAuthor(Author author){
        authorService.saveAuthor(author);
        return "/yazar-list.xhtml?faces-redirect=true";
    }

}
