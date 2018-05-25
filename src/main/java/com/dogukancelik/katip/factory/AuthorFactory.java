package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Author;
import org.springframework.stereotype.Component;

@Component
public interface AuthorFactory {
    Author createAuthor();
}
