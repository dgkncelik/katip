package com.dogukancelik.katip.service;

import com.dogukancelik.katip.model.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublisher();

    Publisher createPublisher();

    void deletePublisher(Publisher publisher);

    public void  deletePublisherById(Long id);

    void savePublisher(Publisher publisher);

    Publisher getPublisherById(Long id);

    Publisher getPublisherByName(String name);
}
