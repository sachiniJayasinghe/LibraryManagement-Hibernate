package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.BookDto;

import java.util.List;

public interface AdminBO extends SuperBO {
    public List<AdminDto> getAllAdmin()  throws Exception ;
    public boolean addAdmin(AdminDto dto) throws Exception ;

    public boolean updateAdmin(AdminDto dto)  throws Exception  ;

    public  boolean deleteAdmin(String admin_id) throws Exception ;

    void getAdmin();
}
