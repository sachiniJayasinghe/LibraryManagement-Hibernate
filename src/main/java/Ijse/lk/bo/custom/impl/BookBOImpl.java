package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.BookBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.BookRepository;
import Ijse.lk.repository.custom.BranchRepository;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Branch);
    BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.BOOK);

    @Override
    public List<BookDto> getAllBook() throws Exception {
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
    public boolean addBook(BookDto dto) throws Exception {
    Branch branch = branchRepository.getBranch(dto.getBranch_id());
    return bookRepository.add(new Book(dto.getBook_id(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getAvailability(),branch));
    }

    @Override
    public boolean updateBook(BookDto dto) throws Exception {
        Branch branch = branchRepository.getBranch(dto.getBranch_id());
        return bookRepository.update(new Book(dto.getBook_id(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getAvailability(),branch));
    }

    @Override
    public boolean deleteBook(String book_id) throws Exception {
        return bookRepository.delete(book_id);
    }
}
