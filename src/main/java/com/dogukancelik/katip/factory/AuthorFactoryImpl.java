package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorFactoryImpl implements AuthorFactory {
    @Override
    public Author createAuthor(){
        return new Author();
    }
}
