package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.HoKhau;

import java.util.List;
import java.util.Optional;

public interface HoKhauService {
    List<HoKhau> findAll();
    Optional<HoKhau> findById(Integer id);
    HoKhau save(HoKhau hoKhau);
    void deleteById(Integer id);
}