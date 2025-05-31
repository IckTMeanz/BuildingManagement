package vn.group27.buildingManagement.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nhankhau")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanKhau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String dantoc;
    private String tongiao;
    private String cccd;
    private Date ngaycap;
    private String noicap;
    private String nghenghiep;
    private String ghichu;

    @ToString.Exclude
    @OneToMany(mappedBy = "nhankhau", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HoKhauNhanKhau> hokhauNhankhauList;


    @OneToMany(mappedBy = "nhankhau", cascade = CascadeType.ALL)
    private List<TamTruTamVang> tamtrutamvangList;


    @OneToMany(mappedBy = "nhankhau", cascade = CascadeType.ALL)
    private List<LichSuThayDoiHoKhau> lichsuthaydoihokhauList;
}