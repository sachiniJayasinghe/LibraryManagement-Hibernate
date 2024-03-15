package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.LoginBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.userDto;
import Ijse.lk.entity.Admin;
import Ijse.lk.entity.User;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.AdminRepository;
import Ijse.lk.repository.custom.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginBOImpl implements LoginBO {

    UserRepository userRepository = (UserRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.USER);

    AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Admin);
    @Override
    public List<userDto> getAllUser() throws Exception {
        List<userDto> allUser= new ArrayList<>();
        List<User> all = userRepository.getAll();
        for (User u : all) {
            allUser.add(new userDto(
                    u.getId(),
                    u.getName(),
                    u.getEmail(),
                    u.getPassword(),
                    u.getAdmin().getAdmin_id()
            ));
        }
        return allUser;
    }

    @Override
    public List<AdminDto> getAllAdmin() throws Exception {
        List<AdminDto> allAdmin= new ArrayList<>();
        List<Admin> all = adminRepository.getAll();
        for (Admin a: all) {
            allAdmin.add(new AdminDto(a.getAdmin_id(),a.getAdmin_name()));
        }
        return allAdmin;
    }
}
