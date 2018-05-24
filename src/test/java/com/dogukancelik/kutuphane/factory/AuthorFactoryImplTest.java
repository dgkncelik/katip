package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
public class AuthorFactoryImplTest {
    public AuthorFactory authorFactory;

    @Before
    public void setup(){
        authorFactory = new AuthorFactoryImpl();
    }

    @Test
    public void testCreateAuthor(){
        assertThat(authorFactory.createAuthor(), instanceOf(Author.class));

    }
}
