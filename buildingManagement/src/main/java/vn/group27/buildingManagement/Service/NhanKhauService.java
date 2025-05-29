package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.NhanKhau;

import java.util.List;
import java.util.Optional;

public interface NhanKhauService {
    List<NhanKhau> findAll();
    Optional<NhanKhau> findById(Integer id);
    NhanKhau save(NhanKhau nhanKhau);
    void deleteById(Integer id);
}