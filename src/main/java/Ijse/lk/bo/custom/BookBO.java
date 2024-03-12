package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
import Ijse.lk.dto.userDto;

import java.util.List;

public interface BookBO extends SuperBO {
    public List<BookDto> getAllBook()  throws Exception ;


    public boolean addBook(BookDto dto) throws Exception ;

    public boolean updateBook(BookDto dto)  throws Exception  ;

    public  boolean deleteBook(String book_id) throws Exception ;
}
