package com.lpq.personallibrary.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lpq.personallibrary.dao.BookMapper;
import com.lpq.personallibrary.entity.Book;

@Service
public class BookService{
    @Resource
    BookMapper bookMapper;
    
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }
    
    public Book getBookById(int id){
        return bookMapper.getBookById(id);
    }
    
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    public int deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }
    
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

}