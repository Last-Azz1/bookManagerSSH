package pers.ssh.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pers.ssh.domain.Book;
import pers.ssh.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BookAction extends ActionSupport implements ModelDriven<Book> {
    private BookService bookService;
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
    static Integer id=null;
    private Book book=new Book();
    @Override
    public Book getModel() {
        return book;
    }

    public String queryAllbook(){
        List<Book> list=bookService.queryAllBook(book);
         HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("allBook",list);
        return "allBook";
    }
    public String deleteBook(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String s=request.getParameter("deleteID");
        bookService.deleteBook(Integer.parseInt(s));
        return "allBookAction";
    }

    public String addBook(){
        if(bookService.addBook(book)){
            return "allBookAction";
        }
        return null;
    }
    public String qbcBook(){
        List<Book> list=bookService.qbcBook(book);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("allBook",list);
        return "allBook";
    }
    public String updateBook(){
        //先调用查询方法 向list中添加数据
        List<Book> list=bookService.qbcBook(book);
        HttpServletRequest request1 = ServletActionContext.getRequest();
        request1.setAttribute("allBook",list);
        HttpServletRequest request = ServletActionContext.getRequest();
        id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("bookname",request.getParameter("bookname"));
        request.setAttribute("booktype",request.getParameter("booktype"));
        request.setAttribute("author",request.getParameter("author"));
        request.setAttribute("publisher",request.getParameter("publisher"));
        request.setAttribute("price",request.getParameter("price"));
        request.setAttribute("stock",request.getParameter("stock"));
        return "allBook";
    }
    public String replaceBook(){
        book.setId(id);
        if (bookService.replaceBook(book)){
            //先调用查询方法 向list中添加数据
            List<Book> list=bookService.qbcBook(book);
            HttpServletRequest request1 = ServletActionContext.getRequest();
            request1.setAttribute("allBook",list);
            return queryAllbook();
        }
        return null;
    }
}
