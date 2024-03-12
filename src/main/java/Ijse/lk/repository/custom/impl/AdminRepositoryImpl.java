package Ijse.lk.repository.custom.impl;

import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.entity.Admin;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.repository.custom.AdminRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    @Override
    public List<Admin> getAll() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Admin> list = session.createNativeQuery("SELECT * FROM admin", Admin.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Admin entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Admin entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String id) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Admin admin = session.get(Admin.class,id);
        session.delete(admin);
        transaction1.commit();
        session.close();
        return true;
    }

    @Override
    public Admin getAdmin(String adminId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Admin admin = session.get(Admin.class,adminId);
        System.out.println("admin :" + admin );
        transaction1.commit();
        session.close();
        return admin;
    }
}
