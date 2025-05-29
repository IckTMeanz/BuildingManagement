package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhauId;

@Repository
public interface HoKhauNhanKhauRepo extends JpaRepository<HoKhauNhanKhau, HoKhauNhanKhauId> {
}