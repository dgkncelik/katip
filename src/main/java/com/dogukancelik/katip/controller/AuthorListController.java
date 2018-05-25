package com.dogukancelik.katip.controller;

import com.dogukancelik.katip.exception.Conflict;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.service.AuthorService;
import com.dogukancelik.katip.service.BookService;
import com.dogukancelik.katip.service.PublisherService;
import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Scope(value = "session")
@Component(value = "authorListController")
@ELBeanName(value = "authorListController")
@Join(path = "/yazar-list", to = "/yazar-list.jsf")
public class AuthorListController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private List<Author> authorList;
    private Author author;
    private boolean edit;
    private Author beforeEdit = null;

    @Autowired
    public AuthorListController(BookService bookService,
                            PublisherService publisherService,
                            AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData(){
        this.authorList = authorService.getAllAuthor();
    }

    public String deleteAuthor(Author deleteAuthor){
        authorService.deleteAuthor(deleteAuthor);
        return "/yazar-list.xhtml?faces-redirect=true";
    }

    public void editAuthor(Author author){
        if(author == null){
            throw new Conflict("Bu yazar nesnesi duzenlenemez -null object-");
        }

        this.author = author;
        edit = true;
    }

    public void save(){
        if(this.author == null){
            throw new Conflict("Bu yazar nesnesi kaydedilemez -null object");
        }

        try {
            authorService.saveAuthor(this.author);
        }catch (Exception e){
            throw new Conflict("Yazar nesnesi kaydedilemedi: " + e.getMessage());
        }

        this.author = authorService.createAuthor();
        this.edit = false;
    }

    public void cancelEdit(){
        edit = false;
    }

}
