package com.dogukancelik.katip.service;

import com.dogukancelik.katip.factory.BookFactory;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.model.Book;
import com.dogukancelik.katip.model.Publisher;
import com.dogukancelik.katip.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public Book getBookByName(String name){
        return bookRepository.findByName(name);
    }

    @Override
    public Book getBookBySubName(String subName){
        return bookRepository.findBySubName(subName);
    }

    @Override
    public List<Book> getBooksBySeriesName(String seriesName){
       return bookRepository.findBySeriesName(seriesName);
    }

    @Override
    public List<Book> getBooksByAuthor(Author author){
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName){
        return bookRepository.findByAuthor(authorService.getAuthorByName(authorName));
    }

    @Override
    public List<Book> getBooksByPublisherName(String publisherName){
        return bookRepository.findByPublisher(publisherService.getPublisherByName(publisherName));
    }

    @Override
    public List<Book> getBooksByPublisher(Publisher publisher){
        return bookRepository.findByPublisher(publisher);
    }

    @Override
    public Book getBookByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

}
