package vn.group27.buildingManagement.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hokhau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HoKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sohokhau;

    private String sonha;
    private String duong;
    private String phuong;
    private String quan;
    private Date ngaylamhokhau;

    @ManyToOne
    @JoinColumn(name = "chuho_id")
    private NhanKhau chuho;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "hokhau")
    private List<HoKhauNhanKhau> hokhauNhankhauList;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    private List<LichSuThayDoiHoKhau> lichsuthaydoihokhauList;

    @OneToMany(mappedBy = "hokhau", cascade = CascadeType.ALL)
    private List<NopTien> noptienList;
}

