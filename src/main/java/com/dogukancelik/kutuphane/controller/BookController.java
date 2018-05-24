package com.dogukancelik.kutuphane.controller;
import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
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
@Component(value = "bookController")
@ELBeanName(value = "bookController")
@Join(path = "/kitap-form", to = "/kitap-form.jsf")
public class BookController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private Book book;
    private String bookAuthorName;
    private String bookPublisherName;

    @Autowired
    public BookController(BookService bookService,
                            PublisherService publisherService,
                            AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.book = bookService.createBook();
        this.bookAuthorName = "";
        this.bookPublisherName = "";
    }

    public String save(){
        Author author = authorService.getAuthorByName(this.bookAuthorName);
        Publisher publisher = publisherService.getPublisherByName(this.bookPublisherName);
        book.setAuthor(author);
        book.setPublisher(publisher);

        bookService.saveBook(book);
        this.book = bookService.createBook();
        this.bookAuthorName = "";
        this.bookPublisherName = "";
        return "/kitap-list.xhtml?faces-redirect=true";
    }

}
