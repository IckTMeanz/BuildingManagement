package vn.group27.buildingManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.entity.Khoanthu;

import java.util.List;

@Repository
public interface KhoanthuRepository extends JpaRepository<Khoanthu, Integer> {
    List<Khoanthu> findByTenkhoanthu(String tenkhoanthu);
    List<Khoanthu> findByLoaiKhoanThu(String loaikhoanthu);
}