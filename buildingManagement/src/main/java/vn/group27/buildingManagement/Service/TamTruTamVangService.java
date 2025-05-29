package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.TamTruTamVang;

import java.util.List;
import java.util.Optional;

// TamTruTamVang Service
public interface TamTruTamVangService {
    List<TamTruTamVang> findAll();
    Optional<TamTruTamVang> findById(Integer id);
    TamTruTamVang save(TamTruTamVang tamTruTamVang);
    void deleteById(Integer id);
}
