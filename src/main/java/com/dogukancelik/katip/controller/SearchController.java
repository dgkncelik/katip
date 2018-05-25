package com.dogukancelik.katip.controller;

import com.dogukancelik.katip.exception.Conflict;
import com.dogukancelik.katip.exception.NotFound;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.model.Book;
import com.dogukancelik.katip.service.AuthorService;
import com.dogukancelik.katip.service.BookService;
import com.dogukancelik.katip.service.PublisherService;
import lombok.Data;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Scope(value = "session")
@Component(value = "searchController")
@ELBeanName(value = "searchController")
@Join(path = "/ara", to = "/ara.jsf")
public class SearchController {
    private BookService bookService;
    private PublisherService publisherService;
    private AuthorService authorService;
    private List<Book> bookList;
    private Book book;
    private boolean edit;
    private String searchCategory;
    private String searchWord;
    private boolean showResult;
    private String authorName;
    private String publisherName;

    @Autowired
    public SearchController(BookService bookService,
                                PublisherService publisherService,
                                AuthorService authorService){
        this.bookService = bookService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookList = new ArrayList<>();
        this.book = bookService.createBook();
    }

    public void search(){
        if(this.bookList != null || !this.bookList.isEmpty()){
            this.bookList = new ArrayList<>();
        }

        String word = this.searchWord;
        String category = this.searchCategory;

        if(category.equals("KITAPADI")){
            this.bookList.add(bookService.getBookByName(word));
        }else if(category.equals("SERIADI")){
            this.bookList.addAll(bookService.getBooksBySeriesName(word));
        }else if(category.equals("YAZAR")){
            Author a = authorService.getAuthorByName(word);
            this.bookList.addAll(bookService.getBooksByAuthor(a));
        }else if(category.equals("ISBN")){
            this.bookList.add(bookService.getBookByIsbn(word));
        }else{
            throw new Conflict("Arama alani ismi izin verilen degerlerin disinda: " + category);
        }

        this.showResult = true;
    }

    public void editBook(Book book){
        this.book = book;
        this.edit = true;
    }

    public void deleteBook(Book book){
        bookService.deleteBook(book);
    }

    public void cancelEdit(){
        this.edit = false;
    }

    public void saveBook(Book savebook){
        try {
            if(authorService.getAuthorByName(this.authorName) == null){
                throw new NotFound(this.authorName + " ile eslesen bir yazar bulunamadi");
            }
            savebook.setAuthor(authorService.getAuthorByName(this.authorName));
        }catch (Exception e){
            throw new Conflict("Yazar servisi bir hata ile karsilasti: " + e.getMessage());
        }


        try {
            if(publisherService.getPublisherByName(this.publisherName) == null){
                throw new NotFound(this.publisherName + " ile eslesen bir yayinevi bulunamadim");
            }
            savebook.setPublisher(publisherService.getPublisherByName(this.publisherName));
        }catch (Exception e){
            throw new Conflict("Yayinevi servisi bir hata ile karsilasti " + e.getMessage());
        }


        try {
            bookService.saveBook(savebook);
        }catch (Exception e){
            throw new Conflict("Kitap kaydedilemedi: " + e.getMessage());
        }

        this.book = bookService.createBook();
        this.edit = false;
    }


}
