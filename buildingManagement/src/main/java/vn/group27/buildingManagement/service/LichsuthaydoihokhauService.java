package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Hokhau;
import vn.group27.buildingManagement.entity.Lichsuthaydoihokhau;
import vn.group27.buildingManagement.repository.LichsuthaydoihokhauRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LichsuthaydoihokhauService {
    
    private final LichsuthaydoihokhauRepository lichsuthaydoihokhauRepository;
    
    @Autowired
    public LichsuthaydoihokhauService(LichsuthaydoihokhauRepository lichsuthaydoihokhauRepository) {
        this.lichsuthaydoihokhauRepository = lichsuthaydoihokhauRepository;
    }
    
    public List<Lichsuthaydoihokhau> getAllLichsuthaydoihokhau() {
        return lichsuthaydoihokhauRepository.findAll();
    }
    
    public Optional<Lichsuthaydoihokhau> getLichsuthaydoihokhauById(Integer id) {
        return lichsuthaydoihokhauRepository.findById(id);
    }
    
    public List<Lichsuthaydoihokhau> getLichsuthaydoihokhauByHokhau(Hokhau hokhau) {
        return lichsuthaydoihokhauRepository.findByHokhau(hokhau);
    }
    
    public List<Lichsuthaydoihokhau> getLichsuthaydoihokhauByNoidung(String noidung) {
        return lichsuthaydoihokhauRepository.findByNoidung(noidung);
    }
    
    public List<Lichsuthaydoihokhau> getLichsuthaydoihokhauByDateRange(LocalDate start, LocalDate end) {
        return lichsuthaydoihokhauRepository.findByNgaythaydoiBetween(start, end);
    }
    
    public Lichsuthaydoihokhau saveLichsuthaydoihokhau(Lichsuthaydoihokhau lichsuthaydoihokhau) {
        return lichsuthaydoihokhauRepository.save(lichsuthaydoihokhau);
    }
    
    public void deleteLichsuthaydoihokhau(Integer id) {
        lichsuthaydoihokhauRepository.deleteById(id);
    }
}