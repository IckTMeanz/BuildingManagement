package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.HokhauNhankhau;
import vn.group27.buildingManagement.entity.HokhauNhankhauId;
import vn.group27.buildingManagement.entity.Nhankhau;

import java.util.List;

@Repository
public interface HokhauNhankhauRepository extends JpaRepository<HokhauNhankhau, HokhauNhankhauId> {
    List<HokhauNhankhau> findByHokhau(Hokhau hokhau);
    List<HokhauNhankhau> findByNhankhau(Nhankhau nhankhau);
    // Sửa từ findByQuanhevchuho thành findByQuanhevoichuho
    List<HokhauNhankhau> findByQuanhevoichuho(String quanhevoichuho);
}