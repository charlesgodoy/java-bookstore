package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Author;
import com.lambdaschool.javabookstore.model.Section;
import com.lambdaschool.javabookstore.repostitory.Sectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sections/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Sectioncontroller {

    @Autowired
    Sectionrepository sectionrepos;

    // http://localhost:2019/sections/sections
    @GetMapping("/sections")
    public List<Section> listAllSections() {
        return sectionrepos.findAll();
    }

    // http://localhost:2019/authors/id/1
    @GetMapping("/id/{id}")
    public Section findSectionById(@PathVariable long id) {
        return sectionrepos.findById(id).get();
    }
}

