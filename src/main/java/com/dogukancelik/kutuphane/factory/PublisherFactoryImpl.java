package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherFactoryImpl implements PublisherFactory {
    @Override
    public Publisher createPublisher(){
        return new Publisher();
    }
}
