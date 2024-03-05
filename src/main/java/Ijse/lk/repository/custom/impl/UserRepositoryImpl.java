package Ijse.lk.repository.custom.impl;

import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.repository.custom.UserRepository;
import Ijse.lk.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAll() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<User> list = session.createNativeQuery("SELECT * FROM users", User.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(User entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;


    }

    @Override
    public boolean update(User entity) throws Exception {
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
        User user = session.get(User.class,id);
        session.delete(user);
        transaction1.commit();
        session.close();
        return true;


    }
}
