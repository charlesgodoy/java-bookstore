package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Book;
import com.lambdaschool.javabookstore.repostitory.Authorrepository;
import com.lambdaschool.javabookstore.repostitory.Bookrepository;
import com.lambdaschool.javabookstore.repostitory.Sectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/data/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Admincontroller {

    @Autowired
    Authorrepository authorrepos;

    @Autowired
    Bookrepository bookrepos;

    @Autowired
    Sectionrepository sectionrepos;

    // puts, posts, deletes
    @PutMapping("/books/{bookid}")
    public Book changeBookById(@RequestBody Book newbook, @PathVariable long bookid) throws URISyntaxException
    {
        Optional<Book> updateBook = bookrepos.findById(bookid);
        if (updateBook.isPresent())
        {
            if (newbook.getTitle() == null)
            {
                newbook.setTitle(updateBook.get().getTitle());
            }

            if (newbook.getISBN() == null)
            {
                newbook.setISBN(updateBook.get().getISBN());
            }

            if (newbook.getCopy() == null)
            {
                newbook.setCopy(updateBook.get().getCopy());
            }

            newbook.setBookid(bookid);
            bookrepos.save(newbook);

            return newbook;
        }
        else
        {
            return null;
        }
    }

    @DeleteMapping("/books/{bookid}")
    public Book deleteBookById(@PathVariable long bookid) {
        var foundBook = bookrepos.findById(bookid);
        if(foundBook.isPresent()) {
//            bookrepos.deleteBook(bookid);       // connected to method in Bookrepository
            bookrepos.deleteById(bookid);
//            return "{" + "\"courseid\":"   + foundBook.get().getBookid() +
//                    ",\"coursename\":" + "\"" + foundBook.get().getTitle() + "\"" +
//                    ",\"instructid\":" + foundBook.get().getAuthors(). + "}";
            return foundBook.get();
        } else {
            return null;
        }
    }
}
