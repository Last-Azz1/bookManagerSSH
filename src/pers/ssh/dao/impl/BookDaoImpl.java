package pers.ssh.dao.impl;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import pers.ssh.dao.BookDao;
import pers.ssh.domain.Book;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List queryAllBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("FROM Book");
            List<Book> list = query.list();
            if (list.size()>0) {
                session.getTransaction().commit();
                return list;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public List qbcBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Criteria criteria =session.createCriteria(Book.class);
            criteria.add(Restrictions.like("bookname","%"+book.getBookname()+"%"));
            criteria.add(Restrictions.like("booktype","%"+book.getBooktype()+"%"));
            criteria.add(Restrictions.like("author","%"+book.getAuthor()+"%"));
            criteria.add(Restrictions.like("publisher","%"+book.getPublisher()+"%"));

            List<Book> list = criteria.list();
            if (list.size()>0) {
                session.getTransaction().commit();
                return list;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean deleteBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Book book =new Book();
            book.setId(id);
            session.delete(book);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean replaceBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

}
