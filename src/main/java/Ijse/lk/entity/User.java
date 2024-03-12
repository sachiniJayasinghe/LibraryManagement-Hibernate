package Ijse.lk.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id",length = 30)
    private String id;
    @Column(name = "user_name")

    private String name;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;


    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private Admin admin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "users")
    private List<BorrowingBooksDetail> borrowingBooksDetails = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email, String password, Admin admin, List<BorrowingBooksDetail> borrowingBooksDetails) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.borrowingBooksDetails = borrowingBooksDetails;
    }

    public User(String id, String name, String email, String password, Admin admin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin = admin;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<BorrowingBooksDetail> getBorrowingBooksDetails() {
        return borrowingBooksDetails;
    }

    public void setBorrowingBooksDetails(List<BorrowingBooksDetail> borrowingBooksDetails) {
        this.borrowingBooksDetails = borrowingBooksDetails;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", borrowingBooksDetails=" + borrowingBooksDetails +
                '}';
    }
}
