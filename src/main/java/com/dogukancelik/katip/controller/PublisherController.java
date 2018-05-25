package com.dogukancelik.katip.controller;

import com.dogukancelik.katip.exception.Conflict;
import com.dogukancelik.katip.model.Publisher;
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
        if(publisher == null){
            throw new Conflict("Bu yayin evi kaydedilemez -null object-");
        }

        try {
            publisherService.savePublisher(publisher);
        }catch (Exception e){
            throw new Conflict("Yazar kaydedilemedi: " + e.getMessage());
        }

        this.publisher = publisherService.createPublisher();
        return "/yayinevi-list.xhtml?faces-redirect=true";
    }

    public String delete(Publisher deletePublisher){
        try {
            publisherService.deletePublisher(deletePublisher);
        }catch (Exception e){
            throw new Conflict("Yazar nesnesi silinemedi: " + e.getMessage());
        }
        return "/yayinevi-list.xhtml?faces-redirect=true";
    }
}
