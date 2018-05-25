package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Book;
import org.springframework.stereotype.Component;

@Component
public interface BookFactory {
    Book createBook();
}
