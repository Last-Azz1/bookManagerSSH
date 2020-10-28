package pers.ssh.dao.impl;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import pers.ssh.dao.ReaderDao;
import pers.ssh.domain.Reader;
import pers.ssh.domain.User;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List queryAllReader(Reader reader) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Query query=session.createQuery("FROM Reader");
            List<Reader> list = query.list();
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
    public List qbcReader(Reader reader) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Criteria criteria =session.createCriteria(Reader.class);
            criteria.add(Restrictions.like("readername","%"+reader.getReadername()+"%"));
            criteria.add(Restrictions.like("readertype","%"+reader.getReadertype()+"%"));
            criteria.add(Restrictions.like("sex","%"+reader.getSex()+"%"));
            criteria.add(Restrictions.like("tel","%"+reader.getTel()+"%"));

            List<Reader> list = criteria.list();
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
    public boolean deleteReader(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Reader reader=new Reader();
            reader.setId(id);
            session.delete(reader);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean addReader(Reader reader) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(reader);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean replaceReader(Reader reader) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(reader);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

}
