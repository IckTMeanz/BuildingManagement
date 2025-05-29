package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.HoKhauNhanKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhauId;

import java.util.List;
import java.util.Optional;

// HoKhauNhanKhau Service
public interface HoKhauNhanKhauService {
    List<HoKhauNhanKhau> findAll();
    Optional<HoKhauNhanKhau> findById(HoKhauNhanKhauId id);
    HoKhauNhanKhau save(HoKhauNhanKhau hoKhauNhanKhau);
    void deleteById(HoKhauNhanKhauId id);
}
