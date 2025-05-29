package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.NopTien;

import java.util.List;
import java.util.Optional;

// NopTien Service
public interface NopTienService {
    List<NopTien> findAll();
    Optional<NopTien> findById(Integer id);
    NopTien save(NopTien nopTien);
    void deleteById(Integer id);
}
