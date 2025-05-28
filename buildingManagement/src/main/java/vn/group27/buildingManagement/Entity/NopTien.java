package vn.group27.buildingManagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "noptien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NopTien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hokhau_id")
    private HoKhau hokhau;

    @ManyToOne
    @JoinColumn(name = "khoanthu_id")
    private KhoanThu khoanthu;

    private String nguoinop;
    private Double sotien;
    private Date ngaynop;
}