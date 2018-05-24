package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.factory.BookFactory;
import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;
import com.dogukancelik.kutuphane.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookFactory bookFactory;
    private BookRepository bookRepository;
    private AuthorService authorService;
    private PublisherService publisherService;

    @Autowired
    public BookServiceImpl(BookFactory bookFactory,
                           BookRepository bookRepository,
                           AuthorService authorService,
                           PublisherService publisherService){
        this.bookFactory = bookFactory;
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(){
        return bookFactory.createBook();
    }

    @Override
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    @Override
    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    @Override
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id){
        return bookRepository.findById(id).get();
    }

    @Override
    public Book getBookByName(String name){
        return bookRepository.findByName(name).get();
    }

    @Override
    public Book getBookBySubName(String subName){
        return bookRepository.findBySubName(subName).get();
    }

    @Override
    public List<Book> getBooksBySeriesName(String seriesName){
        ArrayList<Book> result = new ArrayList<>();
        bookRepository.findBySeriesName(seriesName).ifPresent(result::add);
        return result;
    }

    @Override
    public List<Book> getBooksByAuthor(Author author){
        ArrayList<Book> result = new ArrayList<>();
        bookRepository.findByAuthor(author).ifPresent(result::add);
        return result;
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName){
        ArrayList<Book> result = new ArrayList<>();
        bookRepository.findByAuthor(authorService.getAuthorByName(authorName)).ifPresent(result::add);
        return result;
    }

    @Override
    public List<Book> getBooksByPublisherName(String publisherName){
        ArrayList<Book> result = new ArrayList<>();
        bookRepository.findByPublisher(publisherService.getPublisherByName(publisherName)).ifPresent(result::add);
        return result;
    }

    @Override
    public List<Book> getBooksByPublisher(Publisher publisher){
        ArrayList<Book> result = new ArrayList<>();
        bookRepository.findByPublisher(publisher).ifPresent(result::add);
        return result;
    }

    @Override
    public Book getBookByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn).get();
    }

}
