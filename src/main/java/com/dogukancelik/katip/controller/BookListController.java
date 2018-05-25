package com.dogukancelik.katip.controller;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.model.Book;
import com.dogukancelik.katip.model.Publisher;
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
@Component(value = "bookListController")
@ELBeanName(value = "bookListController")
@Join(path = "/kitap-list", to = "/kitap-list.jsf")
public class BookListController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private List<Book> bookList;
    private Book book;
    private String authorName;
    private String publisherName;
    private boolean edit;

    @Autowired
    public BookListController (BookService bookService,
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
         this.bookList = bookService.getAllBooks();
    }

    public String deleteBook(Book deleteBook){
        bookService.deleteBook(deleteBook);
        return "/kitap-list.xhtml?faces-redirect=true";
    }

    public void editBook(Book book){
        this.book = book;
        edit = true;
    }

    public void save(){
        Author bookAuthor = authorService.getAuthorByName(this.authorName);
        Publisher bookPublisher = publisherService.getPublisherByName(this.publisherName);
        this.book.setPublisher(bookPublisher);
        this.book.setAuthor(bookAuthor);
        bookService.saveBook(this.book);
        this.book = bookService.createBook();
        this.authorName = "";
        this.publisherName = "";
        this.edit = false;
    }

    public void cancelEdit(){
        edit = false;
    }
}
