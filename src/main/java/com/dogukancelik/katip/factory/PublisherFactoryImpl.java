package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherFactoryImpl implements PublisherFactory {
    @Override
    public Publisher createPublisher(){
        return new Publisher();
    }
}
