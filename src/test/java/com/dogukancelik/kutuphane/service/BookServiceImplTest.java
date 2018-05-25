package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.KutuphaneApplication;
import com.dogukancelik.kutuphane.factory.BookFactory;
import com.dogukancelik.kutuphane.model.Author;
import com.dogukancelik.kutuphane.model.Book;
import com.dogukancelik.kutuphane.model.Publisher;
import com.dogukancelik.kutuphane.respository.AuthorRepository;
import com.dogukancelik.kutuphane.respository.BookRepository;
import com.dogukancelik.kutuphane.respository.PublisherRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KutuphaneApplication.class)
public class BookServiceImplTest {
    //TODO: every db entry must clean, after every method execution
    @Autowired
    private BookFactory bookFactory;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    private BookService bookService;

    @Before
    public void setup(){
        bookService = new BookServiceImpl(bookFactory, bookRepository, authorService, publisherService);
    }

    @After
    public void tearDown(){
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void testGetAllBooks(){
        Book b1 = new Book();
        b1.setName("test1");
        b1.setDescription("test1");

        bookRepository.save(b1);
        assertThat(bookService.getAllBooks().get(0), instanceOf(Book.class));
    }

    @Test
    public void testCreateBook(){
        assertThat(bookService.createBook(), instanceOf(Book.class));
    }

    @Test
    public void testDeleteBook(){
        Book b2 = new Book();
        b2.setName("test2");
        b2.setDescription("test2");
        bookRepository.save(b2);

        bookService.deleteBook(b2);
        assertNull(bookRepository.findByName("test2"));
    }

    @Test
    public void testDeleteBookById(){
        Book b3 = new Book();
        b3.setName("test3");
        b3.setDescription("test3");
        bookRepository.save(b3);

        Book test = bookRepository.findByName("test3");
        bookService.deleteBookById(test.getId());
        assertNull(bookRepository.findByName("test3"));
    }

    @Test
    public void testSaveBook(){
        Book b4 = new Book();
        b4.setName("test4");
        b4.setDescription("test4");
        bookService.saveBook(b4);

        assertNotNull(bookService.getBookByName("test4"));
    }

    @Test
    public void testGetBookById(){
        Book b5 = new Book();
        b5.setName("test5");
        b5.setDescription("test5");
        bookRepository.save(b5);

        Book test = bookRepository.findByName("test5");
        assertNotNull(bookService.getBookById(test.getId()));
    }

    @Test
    public void testGetBookByName(){
        Book b6 = new Book();
        b6.setDescription("test6");
        b6.setName("test6");
        bookRepository.save(b6);

        assertNotNull(bookService.getBookByName("test6"));
    }

    @Test
    public void testGetBookBySubName(){
        Book b7 = new Book();
        b7.setName("test7");
        b7.setSubName("test7");
        bookRepository.save(b7);

        assertNotNull(bookService.getBookBySubName("test7"));
    }

    @Test
    public void testGetBookSeriesName(){
        Book b8 = new Book();
        b8.setName("test8");
        b8.setSeriesName("test8");
        bookRepository.save(b8);

        assertThat(bookService.getBooksBySeriesName("test8").get(0), instanceOf(Book.class));
    }

    @Test
    public void testGetBookByAuthor(){
        Author a1 = new Author();
        a1.setName("test");
        authorService.saveAuthor(a1);

        Book b9 = new Book();
        b9.setName("test9");
        b9.setAuthor(a1);
        bookRepository.save(b9);

        assertEquals(bookService.getBooksByAuthor(a1).get(0).getName(), "test9");
    }

    @Test
    public void testGetBookByAuthorName(){
        Author a2 = new Author();
        a2.setName("test2");
        authorService.saveAuthor(a2);

        Book b10 = new Book();
        b10.setName("test10");
        b10.setAuthor(a2);
        bookRepository.save(b10);

        assertEquals(bookService.getBooksByAuthorName("test2").get(0).getName(), "test10");
    }

    @Test
    public void testGetBookByPublisher(){
        Publisher p1 = new Publisher();
        p1.setName("test1");
        publisherService.savePublisher(p1);

        Book b11 = new Book();
        b11.setName("test11");
        b11.setPublisher(p1);
        bookRepository.save(b11);

        assertEquals(bookService.getBooksByPublisher(p1).get(0).getName(), "test11");
    }

    @Test
    public void testGetBookByPublisherName(){
        Publisher p2 = new Publisher();
        p2.setName("test2");
        publisherService.savePublisher(p2);

        Book b12 = new Book();
        b12.setName("test12");
        b12.setPublisher(p2);
        bookRepository.save(b12);
        assertEquals(bookService.getBooksByPublisherName("test2").get(0).getName(), "test12");
    }

    @Test
    public void testGetBookByIsbn(){
        Book b13 = new Book();
        b13.setName("test13");
        b13.setIsbn("test13");
        bookRepository.save(b13);

        assertNotNull(bookService.getBookByIsbn("test13"));
    }
}

