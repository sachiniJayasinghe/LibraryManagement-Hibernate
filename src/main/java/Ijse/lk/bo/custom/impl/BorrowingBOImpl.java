package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.BorrowingBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BorrowingBooksDetailDto;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.BorrowingBooksDetail;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.BookRepository;
import Ijse.lk.repository.custom.BorrowingRepository;
import Ijse.lk.repository.custom.BranchRepository;
import Ijse.lk.repository.custom.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class BorrowingBOImpl implements BorrowingBO {
    BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.BOOK);
    BorrowingRepository borrowingRepository = (BorrowingRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Borrowing);
    UserRepository userRepository = (UserRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.USER);
    BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Branch);


    @Override
    public boolean addBorrowing(String borrowId, String bookId, String userId, LocalDate borrowDate, LocalDate returnDate,Double cost) throws Exception {

        Book book = bookRepository.getBook(bookId);
        User user = userRepository.getUser(userId);

        if (borrowingRepository.add(new BorrowingBooksDetail(borrowId,book,user,borrowDate,returnDate,cost))) {

            Branch branch = branchRepository.getBranch(book.getBranch().getBranch_id());
            book.setAvailability("unAvailable");
            return bookRepository.update(new Book(book.getBook_id(),book.getTitle(),book.getAuthor(),book.getGenre(),book.getAvailability(),branch));

        } else {
            return false;
        }
    }

    @Override
    public boolean deleteBorrowing(String id) throws Exception {
        return false;
    }

    @Override
    public boolean updateBorrowing(String borrowId, String bookId, String userId, String borrowDate, String returnDate) throws Exception {
        return false;
    }

    @Override
    public BorrowingBooksDetailDto searchBorrowing(String id) throws Exception {
        return null;
    }

    @Override
    public List<BorrowingBooksDetailDto> getAllBorrowing() throws Exception {
        return null;
    }

    @Override
    public String getNewBorrowingId() throws Exception {
        String id = borrowingRepository.getNewBorrowingId();
        return id;
    }

    @Override
    public List<BookDto> searchBook() throws Exception {
        List<BookDto> allBook= new ArrayList<>();
        List<Book> all = bookRepository.getAll();
        for (Book b: all) {

            System.out.println(b.getAuthor());
            allBook.add(new BookDto(
                    b.getBook_id(),
                    b.getTitle(),
                    b.getAuthor(),
                    b.getGenre(),
                    b.getAvailability(),
                    b.getBranch().getBranch_id()));
        }
        return allBook;
    }

    @Override
    public String searchBookForName(String bookName) {
        String id = bookRepository.searchBookForName(bookName);
        return id;
    }
}
