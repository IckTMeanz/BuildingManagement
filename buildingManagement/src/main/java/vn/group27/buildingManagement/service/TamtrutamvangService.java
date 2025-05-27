package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Nhankhau;
import vn.group27.buildingManagement.entity.Tamtrutamvang;
import vn.group27.buildingManagement.repository.TamtrutamvangRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TamtrutamvangService {
    
    private final TamtrutamvangRepository tamtrutamvangRepository;
    
    @Autowired
    public TamtrutamvangService(TamtrutamvangRepository tamtrutamvangRepository) {
        this.tamtrutamvangRepository = tamtrutamvangRepository;
    }
    
    public List<Tamtrutamvang> getAllTamtrutamvang() {
        return tamtrutamvangRepository.findAll();
    }
    
    public Optional<Tamtrutamvang> getTamtrutamvangById(Integer id) {
        return tamtrutamvangRepository.findById(id);
    }
    
    public List<Tamtrutamvang> getTamtrutamvangByLoai(String loai) {
        return tamtrutamvangRepository.findByLoai(loai);
    }
    
    public List<Tamtrutamvang> getTamtrutamvangByNhankhau(Nhankhau nhankhau) {
        return tamtrutamvangRepository.findByNhankhau(nhankhau);
    }
    
    public List<Tamtrutamvang> getTamtrutamvangByStartDateRange(LocalDate start, LocalDate end) {
        return tamtrutamvangRepository.findByNgaybatdauBetween(start, end);
    }
    
    public List<Tamtrutamvang> getTamtrutamvangByEndDateRange(LocalDate start, LocalDate end) {
        return tamtrutamvangRepository.findByNgayketthucBetween(start, end);
    }
    
    public Tamtrutamvang saveTamtrutamvang(Tamtrutamvang tamtrutamvang) {
        return tamtrutamvangRepository.save(tamtrutamvang);
    }
    
    public void deleteTamtrutamvang(Integer id) {
        tamtrutamvangRepository.deleteById(id);
    }
}