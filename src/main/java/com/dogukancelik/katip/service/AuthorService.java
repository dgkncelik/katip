package com.dogukancelik.katip.service;

import com.dogukancelik.katip.model.Author;

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
