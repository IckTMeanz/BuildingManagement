package vn.group27.buildingManagement.Repo;



import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.PhuongTien;

import java.util.List;

public interface PhuongTienRepo extends JpaRepository<PhuongTien, String> {
    public List<PhuongTien> findByTrangthai(String tt);
}

