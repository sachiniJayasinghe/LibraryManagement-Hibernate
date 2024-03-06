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
    private long branch_id;


    @Column(name = "branch_name")
    private String branch_name;

    public Branch() {
    }

    public Branch(long branch_id, String branch_name) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
    }

    public long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(long branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id=" + branch_id +
                ", branch_name='" + branch_name + '\'' +
                '}';
    }
}