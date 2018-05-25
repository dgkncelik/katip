package com.dogukancelik.katip.service;

import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.model.Book;
import com.dogukancelik.katip.model.Publisher;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book createBook();

    void deleteBook(Book book);

    void deleteBookById(Long id);

    void saveBook(Book book);

    Book getBookById(Long id);

    Book getBookByName(String name);

    Book getBookBySubName(String subName);

    List<Book> getBooksBySeriesName(String seriesName);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByAuthorName(String authorName);

    List<Book> getBooksByPublisherName(String publisherName);

    List<Book> getBooksByPublisher(Publisher publisher);

    Book getBookByIsbn(String isbn);
}
