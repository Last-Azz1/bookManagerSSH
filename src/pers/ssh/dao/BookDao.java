package pers.ssh.dao;

import pers.ssh.domain.Book;

import java.util.List;

public interface BookDao {
    public List queryAllBook(Book book);
    public List qbcBook(Book book);
    public boolean deleteBook(Integer id);
    public boolean addBook(Book book);
    public boolean replaceBook(Book book);
}
