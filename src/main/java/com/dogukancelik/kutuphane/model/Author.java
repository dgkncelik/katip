package com.dogukancelik.kutuphane.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public String description;

    @OneToMany(mappedBy = "author")
    public List<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        for(Book b : books){
            if(b.equals(book)){
                books.remove(b);
            }
        }
    }
}
