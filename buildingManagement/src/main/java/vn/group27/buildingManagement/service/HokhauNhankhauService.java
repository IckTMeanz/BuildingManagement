package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.HokhauNhankhau;
import vn.group27.buildingManagement.entity.HokhauNhankhauId;
import vn.group27.buildingManagement.entity.Nhankhau;
import vn.group27.buildingManagement.repository.HokhauNhankhauRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HokhauNhankhauService {
    
    private final HokhauNhankhauRepository hokhauNhankhauRepository;
    
    @Autowired
    public HokhauNhankhauService(HokhauNhankhauRepository hokhauNhankhauRepository) {
        this.hokhauNhankhauRepository = hokhauNhankhauRepository;
    }
    
    public List<HokhauNhankhau> getAllHokhauNhankhau() {
        return hokhauNhankhauRepository.findAll();
    }
    
    public Optional<HokhauNhankhau> getHokhauNhankhauById(HokhauNhankhauId id) {
        return hokhauNhankhauRepository.findById(id);
    }
    
    public List<HokhauNhankhau> getHokhauNhankhauByHokhau(Hokhau hokhau) {
        return hokhauNhankhauRepository.findByHokhau(hokhau);
    }
    
    public List<HokhauNhankhau> getHokhauNhankhauByNhankhau(Nhankhau nhankhau) {
        return hokhauNhankhauRepository.findByNhankhau(nhankhau);
    }
    
    public List<HokhauNhankhau> getHokhauNhankhauByQuanhevchuho(String quanhevchuho) {
        return hokhauNhankhauRepository.findByQuanhevoichuho(quanhevchuho);
    }
    
    public HokhauNhankhau saveHokhauNhankhau(HokhauNhankhau hokhauNhankhau) {
        return hokhauNhankhauRepository.save(hokhauNhankhau);
    }
    
    public void deleteHokhauNhankhau(HokhauNhankhauId id) {
        hokhauNhankhauRepository.deleteById(id);
    }
}