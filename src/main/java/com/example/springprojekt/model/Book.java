package com.example.springprojekt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.math.BigDecimal;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private BigDecimal price;
    private int quantity;
    private String image;

    public Book(int id){
        this.id = id;
    }

    public Book() {
    }

    public int getId() {
        return this.id;
    }
}