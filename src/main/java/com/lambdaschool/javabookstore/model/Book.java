package com.lambdaschool.javabookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookid;

    @Column(nullable = false)
    private String title;

    private String ISBN;

    private Integer copy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sectionid")
    @JsonIgnoreProperties("books")
    private Section section;

    @ManyToMany
    @JoinTable(name = "wrote",
            joinColumns = {@JoinColumn(name = "bookid")},
            inverseJoinColumns = {@JoinColumn(name = "authorid")})
    @JsonIgnoreProperties("books")
    private Set<Author> authors  = new HashSet<>();

    public Book() {
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //    public String getBooktitle() {
//        return booktitle;
//    }
//
//    public void setBooktitle(String booktitle) {
//        this.booktitle = booktitle;
//    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getCopy() {
        return copy;
    }

    public void setCopy(Integer copy) {
        this.copy = copy;
    }

    //    public int getCopy() {
//        return copy;
//    }
//
//    public void setCopy(int copy) {
//        this.copy = copy;
//    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}