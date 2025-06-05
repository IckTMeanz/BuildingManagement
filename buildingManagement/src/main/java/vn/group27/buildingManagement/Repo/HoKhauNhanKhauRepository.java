package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhauId;

public interface HoKhauNhanKhauRepository extends JpaRepository<HoKhauNhanKhau, HoKhauNhanKhauId> {
}