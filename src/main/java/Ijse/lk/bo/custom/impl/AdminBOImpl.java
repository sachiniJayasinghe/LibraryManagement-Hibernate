package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.AdminBO;
import Ijse.lk.dto.AdminDto;
import Ijse.lk.dto.BookDto;
import Ijse.lk.entity.Admin;
import Ijse.lk.entity.Book;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.AdminRepository;
import Ijse.lk.repository.custom.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class AdminBOImpl implements AdminBO {
    AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Admin);

    @Override
    public List<AdminDto> getAllAdmin() throws Exception {
        List<AdminDto> allAdmin= new ArrayList<>();
        List<Admin> all = adminRepository.getAll();
        for (Admin a: all) {
            allAdmin.add(new AdminDto(a.getAdmin_id(),a.getAdmin_name()));
        }
        return allAdmin;
    }

    @Override
    public boolean addAdmin(AdminDto dto) throws Exception {
        return adminRepository.add(new Admin(dto.getAdmin_id(), dto.getAdmin_name()));
    }

    @Override
    public boolean updateAdmin(AdminDto dto) throws Exception {
        return adminRepository.update(new Admin(dto.getAdmin_id(), dto.getAdmin_name()));
    }

    @Override
    public boolean deleteAdmin(String admin_id) throws Exception {
        return adminRepository.delete(admin_id);
    }

    @Override
    public void getAdmin() {

    }
}
