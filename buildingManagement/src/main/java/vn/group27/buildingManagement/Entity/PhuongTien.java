package vn.group27.buildingManagement.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "phuongtien")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhuongTien {

    @Id
    private String biensoxe;

    private String loaixe;
    private String mausac;
    private String trangthai = "Chờ duyệt";


    @ManyToOne
    @JoinColumn(name = "hokhau_id")
    @JsonIgnore
    private HoKhau hokhau;
}

