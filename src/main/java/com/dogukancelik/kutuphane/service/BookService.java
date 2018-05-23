package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;

import java.util.List;

public interface BookService {
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