package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.KhoanThu;

import java.util.List;
import java.util.Optional;

public interface KhoanThuService {
    List<KhoanThu> findAll();
    Optional<KhoanThu> findById(Integer id);
    KhoanThu save(KhoanThu khoanThu);
    void deleteById(Integer id);
}