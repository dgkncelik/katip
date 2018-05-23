package com.dogukancelik.kutuphane.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        for (Book b : books){
            if(b.equals(book)){
                books.remove(book);
            }
        }
    }
}
