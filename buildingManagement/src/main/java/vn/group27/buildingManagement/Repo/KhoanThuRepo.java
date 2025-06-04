package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.group27.buildingManagement.DTO.SoLuongHoDaNopVaChuaNopDTO;
import vn.group27.buildingManagement.DTO.TongTienTheoKhoanThuDTO;
import vn.group27.buildingManagement.Entity.KhoanThu;

import java.util.List;

public interface KhoanThuRepo extends JpaRepository<KhoanThu, Integer> {
    public List<KhoanThu> findAll();
    public void deleteById(int id);

    // Tổng số tiền đã thu theo từng khoản thu
    @Query("SELECT new vn.group27.buildingManagement.DTO.TongTienTheoKhoanThuDTO(kt.tenkhoanthu, CAST(COALESCE(SUM(nt.sotien), 0.0) AS double)) " +
            "FROM KhoanThu kt LEFT JOIN kt.noptienList nt GROUP BY kt.tenkhoanthu")
    List<TongTienTheoKhoanThuDTO> getTongTienTheoKhoanThu();

    // Số lượng hộ đã nộp (chưa tính số hộ chưa nộp, tính bên service)
    @Query("SELECT new vn.group27.buildingManagement.DTO.SoLuongHoDaNopVaChuaNopDTO(kt.tenkhoanthu, CAST(COALESCE(COUNT(DISTINCT nt.hokhau.sohokhau), 0) AS integer), 0) " +
            "FROM KhoanThu kt LEFT JOIN kt.noptienList nt GROUP BY kt.tenkhoanthu")
    List<SoLuongHoDaNopVaChuaNopDTO> getSoLuongHoDaNop();
}