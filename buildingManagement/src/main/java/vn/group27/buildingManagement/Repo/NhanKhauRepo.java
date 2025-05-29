package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.NhanKhau;

import java.util.List;

public interface NhanKhauRepo extends JpaRepository<NhanKhau, Integer> {
    public List<NhanKhau> findAll();
}
