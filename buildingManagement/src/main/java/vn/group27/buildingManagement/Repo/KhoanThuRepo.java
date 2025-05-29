package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.Entity.KhoanThu;

@Repository
public interface KhoanThuRepo extends JpaRepository<KhoanThu, Integer> {
}