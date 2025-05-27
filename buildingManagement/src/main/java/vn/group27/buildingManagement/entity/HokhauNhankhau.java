package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "hokhau_nhankhau")
public class HokhauNhankhau {
    @EmbeddedId
    private HokhauNhankhauId id;

    @MapsId("hokhauId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hokhau_id", nullable = false)
    private Hokhau hokhau;

    @MapsId("nhankhauId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nhankhau_id", nullable = false)
    private Nhankhau nhankhau;

    @Column(name = "ngaythemnhankhau", nullable = false)
    private LocalDate ngaythemnhankhau;

    @Column(name = "quanhevoichuho", length = 100)
    private String quanhevoichuho;

    public HokhauNhankhauId getId() {
        return id;
    }

    public void setId(HokhauNhankhauId id) {
        this.id = id;
    }

    public Hokhau getHokhau() {
        return hokhau;
    }

    public void setHokhau(Hokhau hokhau) {
        this.hokhau = hokhau;
    }

    public Nhankhau getNhankhau() {
        return nhankhau;
    }

    public void setNhankhau(Nhankhau nhankhau) {
        this.nhankhau = nhankhau;
    }

    public LocalDate getNgaythemnhankhau() {
        return ngaythemnhankhau;
    }

    public void setNgaythemnhankhau(LocalDate ngaythemnhankhau) {
        this.ngaythemnhankhau = ngaythemnhankhau;
    }

    public String getQuanhevoichuho() {
        return quanhevoichuho;
    }

    public void setQuanhevoichuho(String quanhevoichuho) {
        this.quanhevoichuho = quanhevoichuho;
    }

}