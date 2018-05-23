package com.dogukancelik.kutuphane.factory;

import com.dogukancelik.kutuphane.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public interface PublisherFactory {
    Publisher createPublisher();
}
