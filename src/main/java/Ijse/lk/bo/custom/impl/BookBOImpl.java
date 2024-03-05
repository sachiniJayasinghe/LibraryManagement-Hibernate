package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.BookBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.userDto;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.User;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.BookRepository;
import Ijse.lk.repository.custom.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {
    BookRepository bookRepository = (BookRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.BOOK);

    @Override
    public List<BookDto> getAllBook() throws Exception {
        List<BookDto> allBook= new ArrayList<>();
        List<Book> all = bookRepository.getAll();
        for (Book b: all) {
            allBook.add(new BookDto(b.getBook_id(), b.getTitle(), b.getAuthor(), b.getGenre(),b.getAvailability()));
        }
        return allBook;
    }

    @Override
    public boolean addBook(BookDto dto) throws Exception {
        return bookRepository.add(new Book(dto.getBook_id(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getAvailability()));
    }

    @Override
    public boolean updateBook(BookDto dto) throws Exception {
        return bookRepository.update(new Book(dto.getBook_id(), dto.getTitle(), dto.getAuthor(), dto.getGenre(), dto.getAvailability()));
    }

    @Override
    public boolean deleteBook(long book_id) throws Exception {
        return bookRepository.delete(book_id);
    }
}
