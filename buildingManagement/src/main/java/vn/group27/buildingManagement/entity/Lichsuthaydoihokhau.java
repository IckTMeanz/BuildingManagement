package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "lichsuthaydoihokhau")
public class Lichsuthaydoihokhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nhankhau_id", nullable = false)
    private Nhankhau nhankhau;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hokhau_id", nullable = false)
    private Hokhau hokhau;

    @Column(name = "loaithaydoi")
    private Integer loaithaydoi;

    @Column(name = "thoigian", nullable = false)
    private Instant thoigian;

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

    public Hokhau getHokhau() {
        return hokhau;
    }

    public void setHokhau(Hokhau hokhau) {
        this.hokhau = hokhau;
    }

    public Integer getLoaithaydoi() {
        return loaithaydoi;
    }

    public void setLoaithaydoi(Integer loaithaydoi) {
        this.loaithaydoi = loaithaydoi;
    }

    public Instant getThoigian() {
        return thoigian;
    }

    public void setThoigian(Instant thoigian) {
        this.thoigian = thoigian;
    }

}