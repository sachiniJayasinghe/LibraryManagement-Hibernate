package Ijse.lk.bo.custom.impl;

import Ijse.lk.bo.custom.BranchBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;
import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.entity.User;
import Ijse.lk.repository.RepositoryFactory;
import Ijse.lk.repository.custom.BookRepository;
import Ijse.lk.repository.custom.BranchRepository;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {
    BranchRepository branchRepository = (BranchRepository) RepositoryFactory.getDaoFactory().getDAO(RepositoryFactory.DAOTypes.Branch);

    @Override
    public List<BranchDto> getAllBranch() throws Exception {
        List<BranchDto> allBranch= new ArrayList<>();
        List<Branch> all = branchRepository.getAll();
        for (Branch b: all) {
            allBranch.add(new BranchDto(b.getBranchId(), b.getName()));
        }
        return allBranch;
    }

    @Override
    public boolean addBranch(BranchDto dto) throws Exception {
        return branchRepository.add(new Branch(dto.getBranchId(), dto.getName()));


    }

    @Override
    public boolean updateBranch(BranchDto dto) throws Exception {
        return branchRepository.update(new Branch(dto.getBranchId(),dto.getName()));
    }

    @Override
    public boolean deleteBranch(long branch_id) throws Exception {
        return branchRepository.delete(branch_id);
    }
}
