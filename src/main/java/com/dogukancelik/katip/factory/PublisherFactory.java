package com.dogukancelik.katip.factory;

import com.dogukancelik.katip.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public interface PublisherFactory {
    Publisher createPublisher();
}
