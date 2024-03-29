package Ijse.lk.dto;

public class userDto {
    private String id;
    private String name;
    private String email;
    private String password;
    private String admin_id;


    public userDto(String user_id) {
    }

    public userDto() {
    }

    public userDto(String id, String name, String email, String password, String admin_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.admin_id = admin_id;
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

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "userDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin_id='" + admin_id + '\'' +
                '}';
    }
}
