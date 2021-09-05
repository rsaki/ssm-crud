package com.carpe.service.impl;

import com.carpe.entity.Books;
import com.carpe.mapper.BookMapper;
import com.carpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Carpe
 * @data 2021/9/2
 * @apiNote
 */
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBooks(Books books) {
        return bookMapper.addBooks(books);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryBookByName(String bookName) {
        return bookMapper.queryBookByName(bookName);
    }

}
