package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@SpringBootTest
public class PublisherFactoryImplTest {
    public PublisherFactory publisherFactory;

    @Before
    public void setup(){
        publisherFactory = new PublisherFactoryImpl();
    }

    @Test
    public void testCreatePublisher(){
        assertThat(publisherFactory.createPublisher(), instanceOf(Publisher.class));
    }
}
