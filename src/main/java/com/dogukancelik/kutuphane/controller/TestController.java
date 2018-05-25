package com.dogukancelik.kutuphane.controller;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;
import com.dogukancelik.kutuphane.service.AuthorService;
import com.dogukancelik.kutuphane.service.BookService;
import com.dogukancelik.kutuphane.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;

    @Autowired
    public TestController(BookService bookService,
                          PublisherService publisherService,
                          AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    @GetMapping
    public String test(){
        Book b1 = bookService.createBook();
        Author a1 = authorService.createAuthor();
        Publisher p1 = publisherService.createPublisher();

        p1.setDescription("test0");
        p1.setName("test0");
        p1.addBook(b1);

        a1.setName("test1");
        a1.setDescription("test1");

        b1.setAuthor(a1);
        b1.setDescription("test2");
        b1.setIsbn("test2");
        b1.setName("test2");
        b1.setPublisher(p1);
        b1.setSeriesName("tes2");
        b1.setSubName("test2");

        publisherService.savePublisher(p1);
        authorService.saveAuthor(a1);
        bookService.saveBook(b1);

        return "hello world";
    }
}
