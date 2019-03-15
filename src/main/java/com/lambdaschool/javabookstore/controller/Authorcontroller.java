package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Author;
import com.lambdaschool.javabookstore.repostitory.Authorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Authorcontroller {

    @Autowired
    Authorrepository authorrepos;

    // http://localhost:2019/authors/authors
    @GetMapping("/authors")
    public List<Author> listAllAuthors() {
        return authorrepos.findAll();
    }

    // http://localhost:2019/authors/id/1
    @GetMapping("/id/{id}")
    public Author findAuthorById(@PathVariable long id) {
        return authorrepos.findById(id).get();
    }
}
