package Ijse.lk.dto;

import Ijse.lk.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//
public class BranchDto {
    private String branch_id;
    private String branch_name;
    private String admin_id ;

    public BranchDto() {
    }

    public BranchDto(String branch_id, String branch_name, String admin_id) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.admin_id = admin_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    @Override
    public String toString() {
        return "BranchDto{" +
                "branch_id='" + branch_id + '\'' +
                ", branch_name='" + branch_name + '\'' +
                ", admin_id='" + admin_id + '\'' +
                '}';
    }
}