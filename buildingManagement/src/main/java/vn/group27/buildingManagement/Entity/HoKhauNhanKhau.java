package vn.group27.buildingManagement.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "hokhau_nhankhau")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(HoKhauNhanKhauId.class)
public class HoKhauNhanKhau {
    @Id
    private Integer hokhauId;

    @Id
    private Integer nhankhauId;

    private Date ngaythemnhankhau;
    private String quanhevoichuho;

    @ManyToOne
    @JoinColumn(name = "hokhauId", insertable = false, updatable = false)
    @JsonBackReference(value = "hokhau")
    private HoKhau hokhau;

    @ManyToOne
    @JoinColumn(name = "nhankhauId", insertable = false, updatable = false)
    @JsonIgnore
    private NhanKhau nhankhau;
}

