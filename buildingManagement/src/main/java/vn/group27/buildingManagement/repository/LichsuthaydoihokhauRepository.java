package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.Lichsuthaydoihokhau;
import vn.group27.buildingManagement.entity.Nhankhau;

import java.time.Instant;
import java.util.List;

@Repository
public interface LichsuthaydoihokhauRepository extends JpaRepository<Lichsuthaydoihokhau, Integer> {
    List<Lichsuthaydoihokhau> findByHokhau(Hokhau hokhau);
    // Remove the invalid findByNoidung method
    List<Lichsuthaydoihokhau> findByThoigianBetween(Instant start, Instant end);
    
    // Add missing useful query methods
    List<Lichsuthaydoihokhau> findByNhankhau(Nhankhau nhankhau);
    List<Lichsuthaydoihokhau> findByLoaithaydoi(Integer loaithaydoi);
    
    // Add a fetch join example to avoid N+1 queries
    @Query("SELECT l FROM Lichsuthaydoihokhau l JOIN FETCH l.nhankhau JOIN FETCH l.hokhau WHERE l.hokhau = ?1")
    List<Lichsuthaydoihokhau> findByHokhauWithJoinFetch(Hokhau hokhau);
}