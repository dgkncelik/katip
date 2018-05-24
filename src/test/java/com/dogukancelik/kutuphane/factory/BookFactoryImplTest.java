package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
public class BookFactoryImplTest {
    public BookFactory bookFactory;

    @Before
    public void setup(){
        bookFactory = new BookFactoryImpl();
    }

    @Test
    public void testCreateBook(){
        assertThat(bookFactory.createBook(), instanceOf(Book.class));
    }
}
