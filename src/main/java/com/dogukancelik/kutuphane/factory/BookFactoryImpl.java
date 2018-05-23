package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFactoryImpl implements BookFactory {
    @Override
    public Book createBook(){
        return new Book();
    }
}
