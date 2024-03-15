package Ijse.lk.repository.custom.impl;


import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.BorrowingBooksDetail;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Ijse.lk.repository.custom.BorrowingRepository;

import java.util.List;

public class BorrowingRepositoryImpl implements BorrowingRepository {


    @Override
    public List<BorrowingBooksDetail> getAll() throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<BorrowingBooksDetail> list = session.createNativeQuery("SELECT * FROM borrowingBooksDetails", BorrowingBooksDetail.class).list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean add(BorrowingBooksDetail entity) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(BorrowingBooksDetail entity) throws Exception {
        return false;
    }



    @Override
    public boolean exist(String id) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public String getNewBorrowingId() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String lastBorrowId = null;
        Query<String> query = session.createQuery("select max(b.borrowId) from BorrowingBooksDetail b", String.class);
        List<String> resultList = query.getResultList();

        if (resultList != null && !resultList.isEmpty()) {
            lastBorrowId = resultList.get(0);
        }

        transaction.commit();
        session.close();

        int numericPart = 1;
        if (lastBorrowId != null && lastBorrowId.matches(".*\\d+.*")) {
            String numericStr = lastBorrowId.replaceAll("\\D+", "");
            numericPart = Integer.parseInt(numericStr) + 1;
        }

        String newBorrowId = "BRO" + String.format("%03d", numericPart);

        return newBorrowId;
    }

    @Override
    public User getUsers(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        User users = session.get(User.class,id);
        System.out.println("user :" + users );
        transaction1.commit();
        session.close();
        return users;
    }

    @Override
    public Book getBook(String bookId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Book book = session.get(Book.class,bookId);
        System.out.println("book :" + book );
        transaction1.commit();
        session.close();
        return book;
    }
}
