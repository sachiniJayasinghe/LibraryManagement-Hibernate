package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BorrowingBooksDetailDto;

import java.time.LocalDate;
import java.util.List;
public interface BorrowingBO extends SuperBO {
    public boolean addBorrowing(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate, Double cost) throws Exception;
    public boolean deleteBorrowing(String id) throws Exception;
    public boolean updateBorrowing(String borrowId, String bookId, String userId, String borrowDate, String returnDate) throws Exception;
    public BorrowingBooksDetailDto searchBorrowing(String id) throws Exception;
    public List<BorrowingBooksDetailDto> getAllBorrowing() throws Exception;
    public String getNewBorrowingId() throws Exception;
    public List<BookDto> searchBook() throws Exception;
    String searchBookForName(String bookName);
}
