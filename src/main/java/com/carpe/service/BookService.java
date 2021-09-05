package com.carpe.service;

import com.carpe.entity.Books;

import java.util.List;

/**
 * @author Carpe
 * @data 2021/9/2
 * @apiNote
 */
public interface BookService {
    //增加一本书
    int addBooks(Books books);
    //删除一本书
    int deleteBookById(int id);
    //修改一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(int id);

    //通过书名模糊查询
    List<Books> queryBookByName(String bookName);
}
