package Ijse.lk.repository.custom.impl;

import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.User;
import Ijse.lk.repository.custom.BookRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepositoryImpl  implements BookRepository {

    @Override
    public List<Book> getAll() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Book> list = session.createNativeQuery("SELECT * FROM book", Book.class).list();
        transaction.commit();
        session.close();
        return list;

    }

    @Override
    public boolean add(Book entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Book entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(Long id) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Book book = session.get(Book.class,id);
        session.delete(book);
        transaction1.commit();
        session.close();
        return true;

    }
}
