package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Author;
import com.lambdaschool.javabookstore.model.Book;
import com.lambdaschool.javabookstore.repostitory.Bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Bookcontroller {

    @Autowired
    Bookrepository bookrepos;

    // http://localhost:2019/books/books
    @GetMapping("/books")
    public List<Book> listAllBooks() {
        return bookrepos.findAll();
    }

    // http://localhost:2019/books/id/1
    @GetMapping("/id/{id}")
    public Book findBookById(@PathVariable long id) {
        return bookrepos.findById(id).get();
    }
}
