package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "hokhau")
public class Hokhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sohokhau", nullable = false)
    private Integer id;

    @Column(name = "sonha", length = 100)
    private String sonha;

    @Column(name = "duong", length = 100)
    private String duong;

    @Column(name = "phuong", length = 100)
    private String phuong;

    @Column(name = "quan", length = 100)
    private String quan;

    @Column(name = "ngaylamhokhau", nullable = false)
    private LocalDate ngaylamhokhau;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chuho_id", nullable = false)
    private Nhankhau chuho;

    @OneToMany(mappedBy = "hokhau")
    private Set<HokhauNhankhau> hokhauNhankhaus = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hokhau")
    private Set<Lichsuthaydoihokhau> lichsuthaydoihokhaus = new LinkedHashSet<>();

    @OneToMany(mappedBy = "hokhau")
    private Set<Noptien> noptiens = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getNgaylamhokhau() {
        return ngaylamhokhau;
    }

    public void setNgaylamhokhau(LocalDate ngaylamhokhau) {
        this.ngaylamhokhau = ngaylamhokhau;
    }

    public Nhankhau getChuho() {
        return chuho;
    }

    public void setChuho(Nhankhau chuho) {
        this.chuho = chuho;
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

    public Set<Noptien> getNoptiens() {
        return noptiens;
    }

    public void setNoptiens(Set<Noptien> noptiens) {
        this.noptiens = noptiens;
    }

}