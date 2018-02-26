package com.lpq.personallibrary.dao;

import com.lpq.personallibrary.entity.Book;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookMapper {
    List<Book> getAllBooks();
    Book getBookById(int id);
    int addBook(Book book);
    int deleteBook(int id);
    int updateBook(Book book);
}
