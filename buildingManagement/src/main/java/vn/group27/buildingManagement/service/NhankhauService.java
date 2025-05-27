package vn.group27.buildingManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.entity.Nhankhau;
import vn.group27.buildingManagement.repository.NhankhauRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhankhauService {
    
    private final NhankhauRepository nhankhauRepository;
    
    @Autowired
    public NhankhauService(NhankhauRepository nhankhauRepository) {
        this.nhankhauRepository = nhankhauRepository;
    }
    
    // Các phương thức cơ bản...
    
    public List<Nhankhau> searchNhankhau(String keyword) {
        // Tìm kiếm nhân khẩu theo từ khóa (tên, quê quán, dân tộc)
        List<Nhankhau> result = new ArrayList<>();
        result.addAll(nhankhauRepository.findByHoten(keyword));
        result.addAll(nhankhauRepository.findByQuequan(keyword));
        result.addAll(nhankhauRepository.findByDantoc(keyword));
        return result.stream().distinct().collect(Collectors.toList());
    }
    
    public List<Nhankhau> getNhankhauByAgeRange(int minAge, int maxAge) {
        // Tìm nhân khẩu theo khoảng tuổi
        LocalDate endDate = LocalDate.now().minusYears(minAge);
        LocalDate startDate = LocalDate.now().minusYears(maxAge);
        return nhankhauRepository.findByNgaysinhBetween(startDate, endDate);
    }
}