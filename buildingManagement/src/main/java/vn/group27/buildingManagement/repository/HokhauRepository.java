package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.Nhankhau;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HokhauRepository extends JpaRepository<Hokhau, Integer> {
    List<Hokhau> findByQuan(String quan);
    List<Hokhau> findByPhuong(String phuong);
    List<Hokhau> findByDuong(String duong);
    List<Hokhau> findBySonha(String sonha);
    List<Hokhau> findByNgaylamhokhauBetween(LocalDate start, LocalDate end);
    Hokhau findByChuho(Nhankhau chuho);
}