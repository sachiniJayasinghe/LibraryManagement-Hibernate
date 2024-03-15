package Ijse.lk.repository.custom.impl;

import Ijse.lk.config.SessionFactoryConfig;
import Ijse.lk.dto.BookDto;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.repository.custom.BookRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
    public boolean exist(String id) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction1 = session.beginTransaction();
        Book book = session.get(Book.class, id);
        session.delete(book);
        transaction1.commit();
        session.close();
        return true;

    }


    @Override
    public String searchBookForName(String bookName) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Book where title = :bookTitle");
        query.setParameter("bookTitle", bookName);

        String book_id = null;

        List<Book> list = query.list();
        for (Book book : list) {
            book_id = book.getBook_id();
            System.out.println(book.getBook_id());
        }

        transaction.commit();
        session.close();

        return book_id;
    }

    @Override
    public boolean updateAvailability(String bookId) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("update Book set availability = :availability where book_id = :bookId");
        query.setParameter("availability", "Not Available");
        query.setParameter("bookId", bookId);

        int i = query.executeUpdate();
        transaction.commit();
        session.close();

        return i > 0;
    }

    @Override
    public Book getBook(String bookId) {

        System.out.println(bookId);
        Session session = SessionFactoryConfig.getInstance().getSession();
        Book book = session.get(Book.class, bookId);
        session.close();
        return book;
    }

}