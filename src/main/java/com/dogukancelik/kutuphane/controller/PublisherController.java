package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.model.Publisher;
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
@Component(value = "publisherController")
@ELBeanName(value = "publisherController")
@Join(path = "/yayinevi-form", to = "/yayinevi-form.jsf")
public class PublisherController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private Publisher publisher;

    @Autowired
    public PublisherController(BookService bookService,
                               PublisherService publisherService,
                               AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.publisher = publisherService.createPublisher();
    }

    public String save(){
        publisherService.savePublisher(publisher);
        this.publisher = publisherService.createPublisher();
        return "/yayinevi-list.xhtml?faces-redirect=true";
    }


}
