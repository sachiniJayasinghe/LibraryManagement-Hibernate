package Ijse.lk.repository.custom.impl;


import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.entity.BorrowingBooksDetail;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Ijse.lk.repository.custom.BorrowingRepository;

import java.util.List;

/**
 * @author : L.H
 * @date : 2024-03-11
 * @since : 0.1.0
 **/
public class BorrowingRepositoryImpl implements BorrowingRepository {

    @Override
    public List getAll() throws Exception {
        return null;
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
}
