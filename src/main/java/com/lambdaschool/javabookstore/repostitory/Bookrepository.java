package com.lambdaschool.javabookstore.repostitory;

import com.lambdaschool.javabookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Bookrepository extends JpaRepository<Book, Long> {

//    // method to try to delete book but leave author
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM wrote WHERE bookid = :bookid", nativeQuery = true)
//    void deleteBook(long bookid);

}
