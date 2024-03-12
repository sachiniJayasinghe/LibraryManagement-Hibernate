package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.BranchBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
import Ijse.lk.dto.userDto;
import Ijse.lk.entity.Admin;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.AdminRepository;
import Ijse.lk.repository.custom.BookRepository;
import Ijse.lk.repository.custom.BranchRepository;
import Ijse.lk.repository.custom.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {
    AdminRepository adminRepository = (AdminRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Admin);

    BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Branch);


    @Override
    public List<BranchDto> getAllBranch() throws Exception {
        List<BranchDto> allBranch= new ArrayList<>();
        List<Branch> all = branchRepository.getAll();
        for (Branch b : all) {
            allBranch.add(new BranchDto(b.getBranch_id(),b.getBranch_name(),b.getAdmin().getAdmin_id()));
        }
        return allBranch;
    }

    @Override
    public boolean addBranch(BranchDto dto) throws Exception {
        Admin admin = adminRepository.getAdmin(dto.getAdmin_id());
        return branchRepository.add(new Branch(dto.getBranch_id(), dto.getBranch_name(),admin));
    }

    @Override
    public boolean updateBranch(BranchDto dto) throws Exception {
        Admin admin = adminRepository.getAdmin(dto.getAdmin_id());
        return branchRepository.update(new Branch(dto.getBranch_id(), dto.getBranch_name(),admin));

    }

    @Override
    public boolean deleteBranch(String branch_id) throws Exception {
        return branchRepository.delete(branch_id);

    }
}
