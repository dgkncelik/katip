package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Author;
import org.springframework.stereotype.Component;

@Component
public interface AuthorFactory {
    Author createAuthor();
}
