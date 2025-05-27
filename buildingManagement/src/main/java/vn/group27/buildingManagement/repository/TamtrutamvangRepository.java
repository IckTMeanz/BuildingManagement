package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Nhankhau;
import vn.group27.buildingManagement.entity.Tamtrutamvang;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TamtrutamvangRepository extends JpaRepository<Tamtrutamvang, Integer> {
    List<Tamtrutamvang> findByLoai(String loai);
    List<Tamtrutamvang> findByNhankhau(Nhankhau nhankhau);
    List<Tamtrutamvang> findByNgaybatdauBetween(LocalDate start, LocalDate end);
    List<Tamtrutamvang> findByNgayketthucBetween(LocalDate start, LocalDate end);
}