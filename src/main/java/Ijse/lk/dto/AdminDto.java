package Ijse.lk.dto;

public class AdminDto {
    private String admin_id;
    private String admin_name;


    public AdminDto() {
    }

    public AdminDto(String admin_id, String admin_name) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_name='" + admin_name + '\'' +
                '}';
    }
}
