package Ijse.lk.repository.custom;

import Ijse.lk.entity.Book;
import Ijse.lk.entity.BorrowingBooksDetail;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import Ijse.lk.repository.CrudRepository;

public interface BorrowingRepository extends CrudRepository<BorrowingBooksDetail> {
    public String getNewBorrowingId() throws Exception;
    User getUsers(String id);
    Book getBook(String bookId);
}
