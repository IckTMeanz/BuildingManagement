package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Nhankhau;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NhankhauRepository extends JpaRepository<Nhankhau, Integer> {
    List<Nhankhau> findByHoten(String hoten);
    List<Nhankhau> findByNgaysinhBetween(LocalDate start, LocalDate end);
    List<Nhankhau> findByQuequan(String quequan);
    List<Nhankhau> findByDantoc(String dantoc);
}