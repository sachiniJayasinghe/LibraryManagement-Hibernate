package Ijse.lk.repository.custom;

import Ijse.lk.entity.BorrowingBooksDetail;
import Ijse.lk.repository.CrudRepository;

/**
 * @author : L.H
 * @date : 2024-03-11
 * @since : 0.1.0
 **/
public interface BorrowingRepository extends CrudRepository<BorrowingBooksDetail> {
    public String getNewBorrowingId() throws Exception;
}
