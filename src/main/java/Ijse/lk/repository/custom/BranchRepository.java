package Ijse.lk.repository.custom;

import Ijse.lk.entity.Book;
import Ijse.lk.entity.Branch;
import Ijse.lk.repository.CrudRepository;

public interface BranchRepository  extends CrudRepository<Branch> {


    Branch getBranch(String branchId);

    //    long getId(String branchName);
    public String getId(String branchName);


}