package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.NhanKhau;

public interface NhanKhauRepository extends JpaRepository<NhanKhau, Integer> {
}