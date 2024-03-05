package Ijse.lk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branch")

public class Branch {
    @Id
    @Column(name = "branch_id")
    private int branchId;


    @Column(name = "branch_name")
    private String name;

    public Branch() {
    }



    public Branch(int branchId, String name) {
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", name='" + name + '\'' +
                '}';
    }
}
