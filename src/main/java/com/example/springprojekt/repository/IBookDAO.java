package com.example.springprojekt.repository;

import com.example.springprojekt.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    Optional<Book> getById(int id);
    List<Book> getAll();
    void saveOrUpdate(Book book);
    void delete(int id);
}