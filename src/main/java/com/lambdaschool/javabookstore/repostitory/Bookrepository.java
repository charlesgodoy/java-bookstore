package com.lambdaschool.javabookstore.repostitory;

import com.lambdaschool.javabookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookrepository extends JpaRepository<Book, Long> {
}
