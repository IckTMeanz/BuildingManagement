package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.Khoanthu;
import vn.group27.buildingManagement.entity.Noptien;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoptienRepository extends JpaRepository<Noptien, Integer> {
    List<Noptien> findByHokhau(Hokhau hokhau);
    List<Noptien> findByKhoanthu(Khoanthu khoanthu);
    List<Noptien> findByNgaynopBetween(LocalDate start, LocalDate end);
    List<Noptien> findByTrangthai(Boolean trangthai);
}