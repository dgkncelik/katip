package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.KatipApplication;
import com.dogukancelik.katip.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KatipApplication.class)
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
