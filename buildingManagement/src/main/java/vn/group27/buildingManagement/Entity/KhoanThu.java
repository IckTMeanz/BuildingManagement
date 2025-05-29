package vn.group27.buildingManagement.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "khoanthu")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhoanThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaytao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date thoihan;
    private String tenkhoanthu;
    private Boolean batbuoc;
    private String ghichu;

    @OneToMany(mappedBy = "khoanthu", cascade = CascadeType.ALL)
    private List<NopTien> noptienList;
}
