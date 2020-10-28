package pers.ssh.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pers.ssh.dao.UserDao;
import pers.ssh.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User login(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("FROM User WHERE username=? AND password=?");
            query.setParameter(0, user.getUsername());
            query.setParameter(1, user.getPassword());
            List<User> list = query.list();
            if (list.size()==1) {
                session.getTransaction().commit();
                return list.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
}
