package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.factory.AuthorFactory;
import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorFactory authorFactory;
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorFactory authorFactory,AuthorRepository authorRepository){
        this.authorFactory = authorFactory;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(){
        return authorFactory.createAuthor();
    }

    @Override
    public void deleteAuthor(Author author){
        authorRepository.delete(author);
    }

    @Override
    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

    @Override
    public void saveAuthor(Author author){
        authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id){
       return authorRepository.findById(id).get();
    }

    @Override
    public Author getAuthorByName(String name){
        return authorRepository.findByName(name).get();
    }
}
