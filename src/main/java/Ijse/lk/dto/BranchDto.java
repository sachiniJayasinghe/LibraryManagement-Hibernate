package Ijse.lk.dto;

public class BranchDto {
    private long branch_id;
    private String branch_name;

    public BranchDto() {
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

    public BranchDto(long branch_id, String branch_name) {
        this.branch_id = branch_id;
        this.branch_name = branch_name;
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "branch_id=" + branch_id +
                ", branch_name='" + branch_name + '\'' +
                '}';
    }
}