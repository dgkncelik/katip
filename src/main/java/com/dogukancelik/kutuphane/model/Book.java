package com.dogukancelik.kutuphane.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String subName;
    private String seriesName;


    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;

    private String isbn;
    private String description;

    public Book(){

    }

    @Override
    public String toString(){
        return "";
    }
}
