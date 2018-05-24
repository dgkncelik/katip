package com.dogukancelik.kutuphane.service;

import com.dogukancelik.kutuphane.factory.PublisherFactory;
import com.dogukancelik.kutuphane.model.Publisher;
import com.dogukancelik.kutuphane.respository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    private PublisherFactory publisherFactory;
    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImpl(PublisherFactory publisherFactory, PublisherRepository publisherRepository){
        this.publisherFactory = publisherFactory;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    @Override
    public Publisher createPublisher(){
        return publisherFactory.createPublisher();
    }

    @Override
    public void deletePublisher(Publisher publisher){
        publisherRepository.delete(publisher);
    }

    @Override
    public void  deletePublisherById(Long id){
        publisherRepository.deleteById(id);
    }

    @Override
    public void savePublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id){
        return publisherRepository.findById(id).get();
    }

    @Override
    public Publisher getPublisherByName(String name){
        return publisherRepository.findByName(name).get();
    }
}
