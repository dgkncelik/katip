package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.model.Author;

public interface AuthorService {
    Author createAuthor();

    void deleteAuthor(Author author);

    void deleteAuthorById(Long id);

    void saveAuthor(Author author);

    public Author getAuthorById(Long id);

    Author getAuthorByName(String name);
}
