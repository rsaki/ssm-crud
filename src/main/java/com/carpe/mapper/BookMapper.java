package com.carpe.mapper;

import com.carpe.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Carpe
 * @data 2021/9/2
 * @apiNote @Param作用是用于传递参数从而可以与SQL中的的字段名相对应，一般在2=<参数数<=5时使用最佳。
 */
public interface BookMapper {
    //增加一本书
    int addBooks(Books books);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);
    //修改一本书
    int updateBook(Books books);
    //查询一本书
    Books queryBookById(@Param("bookId") int id);

    //通过书名模糊查询
    List<Books> queryBookByName(@Param("bookName")String bookName);
}
