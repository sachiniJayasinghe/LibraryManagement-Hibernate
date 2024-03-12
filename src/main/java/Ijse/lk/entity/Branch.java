package Ijse.lk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @Column(name = "branch_id",length = 30)
    private String branch_id;

    @Column(name = "branch_name")
    private String branch_name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")
    private List<Book> books = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin;

    public Branch() {
    }

    public Branch(String branchId, String branchName, Admin admin) {
        this.branch_id = branchId;
        this.branch_name = branchName;
        this.admin =admin;
    }

    public Branch(String branch_id, String branch_name, List<Book> books, Admin admin) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
        this.books = books;
        this.admin = admin;
    }

    public Branch(String branchId, String branchName) {
        this.branch_id = branchId;
        this.branch_name = branchName;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branch_id='" + branch_id + '\'' +
                ", branch_name='" + branch_name + '\'' +
                '}';
    }
}

