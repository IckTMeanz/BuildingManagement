package vn.group27.buildingManagement.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "khoanthu")
public class Khoanthu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ngaytao", nullable = false)
    private LocalDate ngaytao;

    @Column(name = "thoihan")
    private LocalDate thoihan;

    @Column(name = "tenkhoanthu", nullable = false, length = 100)
    private String tenkhoanthu;

    @ColumnDefault("false")
    @Column(name = "batbuoc")
    private Boolean batbuoc;

    @Column(name = "ghichu", length = Integer.MAX_VALUE)
    private String ghichu;

    @OneToMany(mappedBy = "khoanthu")
    private Set<Noptien> noptiens = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(LocalDate ngaytao) {
        this.ngaytao = ngaytao;
    }

    public LocalDate getThoihan() {
        return thoihan;
    }

    public void setThoihan(LocalDate thoihan) {
        this.thoihan = thoihan;
    }

    public String getTenkhoanthu() {
        return tenkhoanthu;
    }

    public void setTenkhoanthu(String tenkhoanthu) {
        this.tenkhoanthu = tenkhoanthu;
    }

    public Boolean getBatbuoc() {
        return batbuoc;
    }

    public void setBatbuoc(Boolean batbuoc) {
        this.batbuoc = batbuoc;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Set<Noptien> getNoptiens() {
        return noptiens;
    }

    public void setNoptiens(Set<Noptien> noptiens) {
        this.noptiens = noptiens;
    }

}