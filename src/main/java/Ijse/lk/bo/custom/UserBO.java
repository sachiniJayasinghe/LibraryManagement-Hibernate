package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.userDto;

import java.util.List;

public interface UserBO extends SuperBO {
    public List<userDto> getAllUser()  throws Exception ;
    public boolean addUser(userDto dto) throws Exception ;

    public boolean updateUser(userDto dto)  throws Exception  ;

    public  boolean deleteUser(long user_id) throws Exception ;

}
