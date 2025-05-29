package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.KhoanThu;

import java.util.List;

public interface KhoanThuRepo extends JpaRepository<KhoanThu, Integer> {
    public List<KhoanThu> findAll();
    public void deleteById(int id);
}
