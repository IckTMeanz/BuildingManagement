package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.HoKhau;

import java.util.List;

public interface HoKhauRepo extends JpaRepository<HoKhau, Integer> {
    public List<HoKhau> findAll();


}
