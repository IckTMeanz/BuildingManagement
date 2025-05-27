package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "nhankhau")
public class Nhankhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "hoten", nullable = false, length = 100)
    private String hoten;

    @Column(name = "ngaysinh")
    private LocalDate ngaysinh;

    @Column(name = "gioitinh", length = 10)
    private String gioitinh;

    @Column(name = "dantoc", length = 50)
    private String dantoc;

    @Column(name = "tongiao", length = 50)
    private String tongiao;

    @Column(name = "cccd", nullable = false, length = 20)
    private String cccd;

    @Column(name = "ngaycap")
    private LocalDate ngaycap;

    @Column(name = "noicap", length = 100)
    private String noicap;

    @Column(name = "nghenghiep", length = 100)
    private String nghenghiep;

    @Column(name = "ghichu", length = Integer.MAX_VALUE)
    private String ghichu;

    @OneToOne(mappedBy = "chuho")
    private Hokhau hokhau;

    @OneToMany(mappedBy = "nhankhau")
    private Set<HokhauNhankhau> hokhauNhankhaus = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nhankhau")
    private Set<Lichsuthaydoihokhau> lichsuthaydoihokhaus = new LinkedHashSet<>();

    @OneToMany(mappedBy = "nhankhau")
    private Set<Tamtrutamvang> tamtrutamvangs = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDantoc() {
        return dantoc;
    }

    public void setDantoc(String dantoc) {
        this.dantoc = dantoc;
    }

    public String getTongiao() {
        return tongiao;
    }

    public void setTongiao(String tongiao) {
        this.tongiao = tongiao;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public LocalDate getNgaycap() {
        return ngaycap;
    }

    public void setNgaycap(LocalDate ngaycap) {
        this.ngaycap = ngaycap;
    }

    public String getNoicap() {
        return noicap;
    }

    public void setNoicap(String noicap) {
        this.noicap = noicap;
    }

    public String getNghenghiep() {
        return nghenghiep;
    }

    public void setNghenghiep(String nghenghiep) {
        this.nghenghiep = nghenghiep;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Hokhau getHokhau() {
        return hokhau;
    }

    public void setHokhau(Hokhau hokhau) {
        this.hokhau = hokhau;
    }

    public Set<HokhauNhankhau> getHokhauNhankhaus() {
        return hokhauNhankhaus;
    }

    public void setHokhauNhankhaus(Set<HokhauNhankhau> hokhauNhankhaus) {
        this.hokhauNhankhaus = hokhauNhankhaus;
    }

    public Set<Lichsuthaydoihokhau> getLichsuthaydoihokhaus() {
        return lichsuthaydoihokhaus;
    }

    public void setLichsuthaydoihokhaus(Set<Lichsuthaydoihokhau> lichsuthaydoihokhaus) {
        this.lichsuthaydoihokhaus = lichsuthaydoihokhaus;
    }

    public Set<Tamtrutamvang> getTamtrutamvangs() {
        return tamtrutamvangs;
    }

    public void setTamtrutamvangs(Set<Tamtrutamvang> tamtrutamvangs) {
        this.tamtrutamvangs = tamtrutamvangs;
    }

}