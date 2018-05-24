package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.model.Publisher;
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

import java.util.List;

@Data
@Scope (value = "session")
@Component (value = "publisherListController")
@ELBeanName(value = "publisherListController")
@Join(path = "/yayinevi-list", to = "/yayinevi-list.jsf")
public class PublisherListController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private List<Publisher> publisherList;

    @Autowired
    public PublisherListController(BookService bookService,
                               PublisherService publisherService,
                               AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;

    }

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        this.publisherList = publisherService.getAllPublisher();
    }

}
