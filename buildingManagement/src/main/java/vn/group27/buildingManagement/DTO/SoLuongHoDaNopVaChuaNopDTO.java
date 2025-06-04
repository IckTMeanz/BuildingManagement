package vn.group27.buildingManagement.DTO;

public class SoLuongHoDaNopVaChuaNopDTO {
    private String tenKhoanThu;
    private Integer soHoDaNop; // Đổi từ Long thành Integer
    private Integer soHoChuaNop; // Đổi từ Long thành Integer

    public SoLuongHoDaNopVaChuaNopDTO(String tenKhoanThu, Integer soHoDaNop, Integer soHoChuaNop) {
        this.tenKhoanThu = tenKhoanThu;
        this.soHoDaNop = soHoDaNop;
        this.soHoChuaNop = soHoChuaNop;
    }

    // getters và setters
    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public Integer getSoHoDaNop() {
        return soHoDaNop;
    }

    public Integer getSoHoChuaNop() {
        return soHoChuaNop;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public void setSoHoDaNop(Integer soHoDaNop) {
        this.soHoDaNop = soHoDaNop;
    }

    public void setSoHoChuaNop(Integer soHoChuaNop) {
        this.soHoChuaNop = soHoChuaNop;
    }
}