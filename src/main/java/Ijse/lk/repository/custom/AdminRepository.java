package Ijse.lk.repository.custom;

import Ijse.lk.entity.Admin;
import Ijse.lk.entity.Branch;
import Ijse.lk.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin> {
    Admin getAdmin(String adminId);


}
