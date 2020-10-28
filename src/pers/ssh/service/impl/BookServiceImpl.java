package pers.ssh.service.impl;

import pers.ssh.dao.BookDao;
import pers.ssh.domain.Book;
import pers.ssh.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List queryAllBook(Book book) {
        return bookDao.queryAllBook(book);
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public boolean replaceBook(Book book) {
        return bookDao.replaceBook(book);
    }

    @Override
    public List qbcBook(Book book) {
        return bookDao.qbcBook(book);
    }
}
