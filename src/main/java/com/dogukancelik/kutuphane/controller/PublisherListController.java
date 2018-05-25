package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.exception.Conflict;
import com.dogukancelik.kutuphane.exception.NotFound;
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
    private Publisher publisher;
    private boolean edit;


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

    public String deletePublisher(Publisher deletePublisher){
        if(deletePublisher == null){
            throw new Conflict("BU yayinevi kaydedilemez -null object-");
        }

        try {
            publisherService.deletePublisher(deletePublisher);
        }catch (Exception e){
            throw new Conflict("Yayinevi servisi bir hata ile karsilasti: " + e.getMessage());
        }

        return "/yayinevi-list.xhtml?faces-redirect=true";
    }


    public void editPublisher(Publisher publisher){
        if(publisher == null){
            throw new Conflict("Bu yayin evi duzenlenemez -null object");
        }

        this.publisher = publisher;
        edit = true;
    }

    public void save(){
        if(this.publisher == null){
            throw new Conflict("Bu yayinevi kaydedilemez -null object-");
        }

        try {
            publisherService.savePublisher(this.publisher);
        }catch (Exception e){
            throw new Conflict("Yayinevi kaydeilemedi: " + e.getMessage());
        }


        this.publisher = publisherService.createPublisher();
        edit = false;
    }

    public void cancelEdit(){
        edit = false;
    }

}
