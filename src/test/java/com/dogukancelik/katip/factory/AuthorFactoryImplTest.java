package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.KatipApplication;
import com.dogukancelik.katip.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = KatipApplication.class)
public class AuthorFactoryImplTest {
    private AuthorFactory authorFactory;

    @Before
    public void setup(){
        authorFactory = new AuthorFactoryImpl();
    }

    @Test
    public void testCreateAuthor(){
        assertThat(authorFactory.createAuthor(), instanceOf(Author.class));

    }
}
