package vn.group27.buildingManagement.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hokhau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sohokhau;

    private String sonha;
    private String duong;
    private String phuong;
    private String quan;
    private Date ngaylamhokhau;

    @ManyToOne
    @JoinColumn(name = "chuho_id")
    private NhanKhau chuho;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    private List<HoKhauNhanKhau> hokhauNhankhauList;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    private List<LichSuThayDoiHoKhau> lichsuthaydoihokhauList;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    private List<NopTien> noptienList;

    public Integer getSohokhau() {
        return sohokhau;
    }

    public void setSohokhau(Integer sohokhau) {
        this.sohokhau = sohokhau;
    }

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String duong) {
        this.duong = duong;
    }

    public String getPhuong() {
        return phuong;
    }

    public void setPhuong(String phuong) {
        this.phuong = phuong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public Date getNgaylamhokhau() {
        return ngaylamhokhau;
    }

    public void setNgaylamhokhau(Date ngaylamhokhau) {
        this.ngaylamhokhau = ngaylamhokhau;
    }

    public NhanKhau getChuho() {
        return chuho;
    }

    public void setChuho(NhanKhau chuho) {
        this.chuho = chuho;
    }
}

