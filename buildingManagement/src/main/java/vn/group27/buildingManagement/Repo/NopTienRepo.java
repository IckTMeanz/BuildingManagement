package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.NopTien;

import java.util.List;

public interface NopTienRepo extends JpaRepository<NopTien, Integer> {
    public List<NopTien> findAll();

    public NopTien findById(int id);
}
