package Ijse.lk.repository.custom;

import Ijse.lk.dto.BookDto;
import Ijse.lk.entity.Book;
import Ijse.lk.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book> {

    String searchBookForName(String bookName);

    boolean updateAvailability( String bookId);

    Book getBook(String bookId);
}
