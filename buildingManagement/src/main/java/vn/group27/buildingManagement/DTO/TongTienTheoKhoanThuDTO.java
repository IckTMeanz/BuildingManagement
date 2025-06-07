package vn.group27.buildingManagement.DTO;

public class TongTienTheoKhoanThuDTO {
    private String tenKhoanThu;
    private Double tongTien;

    public TongTienTheoKhoanThuDTO(String tenKhoanThu, Double tongTien) {
        this.tenKhoanThu = tenKhoanThu;
        this.tongTien = tongTien;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
}
