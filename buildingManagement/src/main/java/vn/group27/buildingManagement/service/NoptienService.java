package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.Khoanthu;
import vn.group27.buildingManagement.entity.Noptien;
import vn.group27.buildingManagement.repository.NoptienRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoptienService {
    
    private final NoptienRepository noptienRepository;
    
    @Autowired
    public NoptienService(NoptienRepository noptienRepository) {
        this.noptienRepository = noptienRepository;
    }
    
    public List<Noptien> getAllNoptien() {
        return noptienRepository.findAll();
    }
    
    public Optional<Noptien> getNoptienById(Integer id) {
        return noptienRepository.findById(id);
    }
    
    public List<Noptien> getNoptienByHokhau(Hokhau hokhau) {
        return noptienRepository.findByHokhau(hokhau);
    }
    
    public List<Noptien> getNoptienByKhoanthu(Khoanthu khoanthu) {
        return noptienRepository.findByKhoanthu(khoanthu);
    }
    
    public List<Noptien> getNoptienByDateRange(LocalDate start, LocalDate end) {
        return noptienRepository.findByNgaynopBetween(start, end);
    }
    
    public List<Noptien> getNoptienByTrangthai(Boolean trangthai) {
        return noptienRepository.findByTrangthai(trangthai);
    }
    
    public Noptien saveNoptien(Noptien noptien) {
        return noptienRepository.save(noptien);
    }
    
    public void deleteNoptien(Integer id) {
        noptienRepository.deleteById(id);
    }
}