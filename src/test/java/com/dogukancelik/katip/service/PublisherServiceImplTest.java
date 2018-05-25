package com.dogukancelik.katip.service;

import com.dogukancelik.katip.KatipApplication;
import com.dogukancelik.katip.factory.PublisherFactory;
import com.dogukancelik.katip.model.Publisher;
import com.dogukancelik.katip.respository.AuthorRepository;
import com.dogukancelik.katip.respository.BookRepository;
import com.dogukancelik.katip.respository.PublisherRepository;
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
public class PublisherServiceImplTest {
    @Autowired
    public PublisherFactory publisherFactory;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    private PublisherService publisherService;

    @Before
    public void setup(){
        publisherService = new PublisherServiceImpl(publisherFactory, publisherRepository);
    }

    @After
    public void tearDown(){
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void testGetAllPublisher(){
        Publisher p1 = new Publisher();
        p1.setName("test1");
        p1.setDescription("test1");
        publisherRepository.save(p1);

        assertThat(publisherService.getAllPublisher().get(0), instanceOf(Publisher.class));
    }

    @Test
    public void testCreatePublisher(){
        assertThat(publisherService.createPublisher(), instanceOf(Publisher.class));
    }

    @Test
    public void testDeletePublisher(){
        Publisher p2 = new Publisher();
        p2.setName("test2");
        publisherRepository.save(p2);

        publisherService.deletePublisher(p2);
        assertFalse(publisherRepository.findByName("test2").isPresent());
    }

    @Test
    public void testDeletePublisherById(){
        Publisher p3 = new Publisher();
        p3.setName("test3");
        publisherRepository.save(p3);

        Long id = publisherRepository.findByName("test3").get().getId();
        publisherService.deletePublisherById(id);
        assertFalse(publisherRepository.findByName("test3").isPresent());
    }

    @Test
    public void testSavePublisher(){
        Publisher p4 = new Publisher();
        p4.setName("test4");
        publisherRepository.save(p4);

        assertNotNull(publisherService.getPublisherByName("test4"));
    }

    @Test
    public void testGetPublisherById(){
        Publisher p5 = new Publisher();
        p5.setName("test5");
        publisherRepository.save(p5);

        Long id = publisherRepository.findByName("test5").get().getId();
        assertEquals(publisherService.getPublisherById(id).getName(), "test5");
    }

    @Test
    public void testGetPublisherByName(){
        Publisher p6 = new Publisher();
        p6.setName("test6");
        publisherRepository.save(p6);

        assertNotNull(publisherService.getPublisherByName("test6"));
    }
}
