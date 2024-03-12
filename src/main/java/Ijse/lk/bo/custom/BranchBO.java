package Ijse.lk.bo.custom;

import Ijse.lk.bo.SuperBO;
import Ijse.lk.dto.BookDto;
import Ijse.lk.dto.BranchDto;

import java.util.List;

public interface BranchBO extends SuperBO {
    public List<BranchDto> getAllBranch()  throws Exception ;
    public boolean addBranch(BranchDto dto) throws Exception ;

    public boolean updateBranch(BranchDto dto)  throws Exception  ;

    public  boolean deleteBranch(String branch_id) throws Exception ;
}
