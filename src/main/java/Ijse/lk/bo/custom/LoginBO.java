package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.userDto;

import java.util.List;

public interface LoginBO extends SuperBO {
    public List<userDto> getAllUser() throws Exception;
    public List<AdminDto> getAllAdmin() throws Exception;
}
