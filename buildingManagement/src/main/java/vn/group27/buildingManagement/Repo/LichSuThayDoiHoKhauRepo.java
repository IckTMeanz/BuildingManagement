package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.Entity.LichSuThayDoiHoKhau;

@Repository
public interface LichSuThayDoiHoKhauRepo extends JpaRepository<LichSuThayDoiHoKhau, Integer> {
}