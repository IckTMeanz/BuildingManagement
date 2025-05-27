package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tamtrutamvang")
public class Tamtrutamvang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nhankhau_id", nullable = false)
    private Nhankhau nhankhau;

    @Column(name = "trangthai", nullable = false, length = 20)
    private String trangthai;

    @Column(name = "diachitamtrutamvang", length = 200)
    private String diachitamtrutamvang;

    @Column(name = "thoigian", nullable = false)
    private Instant thoigian;

    @Column(name = "noidungdenghi", length = Integer.MAX_VALUE)
    private String noidungdenghi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Nhankhau getNhankhau() {
        return nhankhau;
    }

    public void setNhankhau(Nhankhau nhankhau) {
        this.nhankhau = nhankhau;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public String getDiachitamtrutamvang() {
        return diachitamtrutamvang;
    }

    public void setDiachitamtrutamvang(String diachitamtrutamvang) {
        this.diachitamtrutamvang = diachitamtrutamvang;
    }

    public Instant getThoigian() {
        return thoigian;
    }

    public void setThoigian(Instant thoigian) {
        this.thoigian = thoigian;
    }

    public String getNoidungdenghi() {
        return noidungdenghi;
    }

    public void setNoidungdenghi(String noidungdenghi) {
        this.noidungdenghi = noidungdenghi;
    }

}