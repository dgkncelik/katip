package com.dogukancelik.katip.service;

import com.dogukancelik.katip.KatipApplication;
import com.dogukancelik.katip.factory.AuthorFactory;
import com.dogukancelik.katip.model.Author;
import com.dogukancelik.katip.respository.AuthorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KatipApplication.class)
public class AuthorServiceImplTest {
    //TODO: have to disable of recording authors with same name.
    @Autowired
    private AuthorFactory authorFactory;

    @Autowired
    private AuthorRepository authorRepository;

    private AuthorService authorService;

    @Before
    public void setup(){
        authorService = new AuthorServiceImpl(authorFactory, authorRepository);
    }

    @After
    public void tearDown(){
        authorRepository.deleteAll();
    }

    @Test
    public void testGetAllAuthor(){
        Author a1 = new Author();
        a1.setName("test");
        a1.setDescription("test2");

        authorRepository.save(a1);
        assertThat(authorService.getAllAuthor().get(0), instanceOf(Author.class));
    }

    @Test
    public void testCreateAuthor(){
        assertThat(authorService.createAuthor(), instanceOf(Author.class));
    }

    @Test
    public void testDeleteAuthor(){
        Author a2 = new Author();
        a2.setName("test3");
        a2.setDescription("test4");
        authorRepository.save(a2);

        authorService.deleteAuthor(a2);
        assertNull(authorRepository.findByName("test3"));
    }

    @Test
    public void testDeleteAuthorById(){
        Author a3 = new Author();
        a3.setName("test5");
        a3.setDescription("test6");
        authorRepository.save(a3);

        Author test = authorRepository.findByName("test5");
        authorService.deleteAuthorById(test.getId());
        assertNull(authorRepository.findByName("test5"));
    }

    @Test
    public void testSaveAuthor(){
        Author a4 = new Author();
        a4.setName("test6");
        a4.setDescription("test6");
        authorService.saveAuthor(a4);

        assertNotNull(authorService.getAuthorByName("test6"));
    }

    @Test
    public void testGetAuthorById(){
        Author a5 = new Author();
        a5.setName("test7");
        a5.setDescription("test8");
        authorRepository.save(a5);

        Author test = authorRepository.findByName("test7");
        assertNotNull(authorService.getAuthorById(test.getId()));
    }

    @Test
    public void testGetAuthorByName(){
        Author a6 = new Author();
        a6.setName("test8");
        a6.setDescription("test9");
        authorRepository.save(a6);

        assertNotNull(authorService.getAuthorByName("test8"));
    }
}
