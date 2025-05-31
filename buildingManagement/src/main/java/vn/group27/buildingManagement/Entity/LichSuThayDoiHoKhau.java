package vn.group27.buildingManagement.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "lichsuthaydoihokhau")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LichSuThayDoiHoKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "nhankhau_id")
    private NhanKhau nhankhau;

    @ManyToOne
    @JoinColumn(name = "hokhau_id")
    private HoKhau hokhau;

    private Integer loaithaydoi;
    private Date thoigian;
}

