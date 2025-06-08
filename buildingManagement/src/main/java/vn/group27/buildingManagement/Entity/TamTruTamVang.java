package vn.group27.buildingManagement.Entity;
import jakarta.persistence.*;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "tamtrutamvang")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TamTruTamVang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String trangthai;
    private String diachitamtrutamvang;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoigian;
    private String noidungdenghi;

    @ManyToOne
    @JoinColumn(name = "nhankhau_id")
    private NhanKhau nhankhau;
}

