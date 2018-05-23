package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookFactory {
    Book createBook();
}
