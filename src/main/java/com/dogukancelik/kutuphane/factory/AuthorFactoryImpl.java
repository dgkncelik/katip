package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorFactoryImpl implements AuthorFactory {
    @Override
    public Author createAuthor(){
        return new Author();
    }
}
