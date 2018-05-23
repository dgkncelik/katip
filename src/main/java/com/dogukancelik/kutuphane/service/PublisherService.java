package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.model.Publisher;

public interface PublisherService {
    Publisher createPublisher();

    void deletePublisher(Publisher publisher);

    public void  deletePublisherById(Long id);

    void savePublisher(Publisher publisher);

    Publisher getPublisherById(Long id);

    Publisher getPublisherByName(String name);
}
