package Ijse.lk.repository.custom.impl;

import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import Ijse.lk.repository.custom.BranchRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BranchRepositoryImpl implements BranchRepository {

    @Override
    public List<Branch> getAll() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Branch> list = session.createNativeQuery("SELECT * FROM branch", Branch.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(Branch entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        System.out.println(entity);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Branch entity) throws Exception {
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
        Branch branch = session.get(Branch.class,id);
        session.delete(branch);
        transaction1.commit();
        session.close();
        return true;
    }
}
