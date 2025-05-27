package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Khoanthu;
import vn.group27.buildingManagement.repository.KhoanthuRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KhoanthuService {
    
    private final KhoanthuRepository khoanthuRepository;
    
    @Autowired
    public KhoanthuService(KhoanthuRepository khoanthuRepository) {
        this.khoanthuRepository = khoanthuRepository;
    }
    
    public List<Khoanthu> getAllKhoanthu() {
        return khoanthuRepository.findAll();
    }
    
    public Optional<Khoanthu> getKhoanthuById(Integer id) {
        return khoanthuRepository.findById(id);
    }
    
    public List<Khoanthu> getKhoanthuByTenkhoanthu(String tenkhoanthu) {
        return khoanthuRepository.findByTenkhoanthu(tenkhoanthu);
    }
    
    public List<Khoanthu> getKhoanthuByLoaikhoanthu(String loaikhoanthu) {
        return khoanthuRepository.findByLoaiKhoanThu(loaikhoanthu);
    }
    
    public Khoanthu saveKhoanthu(Khoanthu khoanthu) {
        return khoanthuRepository.save(khoanthu);
    }
    
    public void deleteKhoanthu(Integer id) {
        khoanthuRepository.deleteById(id);
    }
}