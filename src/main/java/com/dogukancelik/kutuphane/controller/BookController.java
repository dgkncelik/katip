package com.dogukancelik.kutuphane.controller;
import com.dogukancelik.kutuphane.exception.Conflict;
import com.dogukancelik.kutuphane.exception.NotFound;
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
        Author author;
        Publisher publisher;

        try {
            author = authorService.getAuthorByName(this.bookAuthorName);
            if(author == null){
                throw new NotFound(this.bookAuthorName + "ismine sahip bir yazar bulunamadi");
            }
        }catch (Exception e){
            throw new Conflict("Yazar servisi bi hata ile karsilasti: " + e.getMessage());
        }


        try {
            publisher = publisherService.getPublisherByName(this.bookPublisherName);
            if(publisher == null){
                throw new NotFound(this.bookPublisherName + "ismina sahip bir yayinevi bulunamadi");
            }
        }catch (Exception e){
            throw new Conflict("Yazar servisi bir hata ile karsilasti");
        }

        book.setAuthor(author);
        book.setPublisher(publisher);

        try {
            bookService.saveBook(book);
        }catch (Exception e){
            throw new Conflict("Kitap kaydedilemedi: " + e.getMessage());
        }

        this.book = bookService.createBook();
        this.bookAuthorName = "";
        this.bookPublisherName = "";
        return "/kitap-list.xhtml?faces-redirect=true";
    }

    public String delete(Book deleteBook){
        try {
            bookService.deleteBook(deleteBook);
        }catch (Exception e){
            throw new Conflict("Kitap silinemedi: " + e.getMessage());
        }
        return "/kitap-list.xhtml?faces-redirect=true";
    }

}
