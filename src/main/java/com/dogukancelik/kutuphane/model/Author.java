package com.dogukancelik.kutuphane.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "author")
    public List<Book> books;

    public Author(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        book.setAuthor(this);
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
