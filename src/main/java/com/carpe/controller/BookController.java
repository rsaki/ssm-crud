package com.carpe.controller;

import com.carpe.entity.Books;
import com.carpe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Carpe
 * @data 2021/9/3
 * @apiNote Controller层用来交互jsp页面
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private String error;
    private String queryBookName;
    //Controller层调用Service层
    @Autowired
    //如果实现类用注解这里就不用@Qualifier
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部&&模糊查询
    @RequestMapping("/allBook")
    public String list(@RequestParam(defaultValue="")String queryBookName,Model model) {
        String i=queryBookName;
        if (queryBookName.equals("")||queryBookName==null){
            i=this.queryBookName;
        }
        List<Books> list = bookService.queryBookByName(i);
        model.addAttribute("error",error);
        error=null;
        model.addAttribute("list", list);
        this.queryBookName=null;
        return "allBook";
    }

    //跳转增加页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    //添加书籍方法
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBooks(books);
        return "redirect:/book/allBook";//重定向到@RequestMapping("allBook")
    }

    //跳转修改页面 rest风格
    @RequestMapping("/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable("id") int id, Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    //修改书籍方法
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍 传统的?xx=xxx 传参
    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //判断查找书籍后跳转到/allBook
    //为什么这麽写？因为这样才能解决不能重定向的问题。
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName) {
        List<Books> books = bookService.queryBookByName(queryBookName);
        if (queryBookName.length() < 2) {
            error = "长度要大于1个字符";
            return "redirect:/book/allBook";
        } else if (books.size() == 0) {
            error = "未找到该书籍";
            return "redirect:/book/allBook";
        } else {
            this.queryBookName=queryBookName;
            return "redirect:/book/allBook";
        }
    }

}
