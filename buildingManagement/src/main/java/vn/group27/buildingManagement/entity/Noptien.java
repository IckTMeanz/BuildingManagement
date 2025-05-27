package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "noptien")
public class Noptien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hokhau_id", nullable = false)
    private Hokhau hokhau;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "khoanthu_id", nullable = false)
    private Khoanthu khoanthu;

    @Column(name = "nguoinop", length = 100)
    private String nguoinop;

    @Column(name = "sotien", precision = 12, scale = 2)
    private BigDecimal sotien;

    @Column(name = "ngaynop")
    private LocalDate ngaynop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Hokhau getHokhau() {
        return hokhau;
    }

    public void setHokhau(Hokhau hokhau) {
        this.hokhau = hokhau;
    }

    public Khoanthu getKhoanthu() {
        return khoanthu;
    }

    public void setKhoanthu(Khoanthu khoanthu) {
        this.khoanthu = khoanthu;
    }

    public String getNguoinop() {
        return nguoinop;
    }

    public void setNguoinop(String nguoinop) {
        this.nguoinop = nguoinop;
    }

    public BigDecimal getSotien() {
        return sotien;
    }

    public void setSotien(BigDecimal sotien) {
        this.sotien = sotien;
    }

    public LocalDate getNgaynop() {
        return ngaynop;
    }

    public void setNgaynop(LocalDate ngaynop) {
        this.ngaynop = ngaynop;
    }

}