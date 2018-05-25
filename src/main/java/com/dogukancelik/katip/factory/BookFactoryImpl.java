package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFactoryImpl implements BookFactory {
    @Override
    public Book createBook(){
        return new Book();
    }
}
