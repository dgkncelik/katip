package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();

    Author createAuthor();

    void deleteAuthor(Author author);

    void deleteAuthorById(Long id);

    void saveAuthor(Author author);

    public Author getAuthorById(Long id);

    Author getAuthorByName(String name);
}
