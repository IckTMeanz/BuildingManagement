package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.KhoanThu;
import vn.group27.buildingManagement.Repo.KhoanThuRepo;

import java.util.List;
import java.util.Optional;

@Service
public class KhoanThuServiceImpl implements KhoanThuService {

    private final KhoanThuRepo khoanThuRepo;

    @Autowired
    public KhoanThuServiceImpl(KhoanThuRepo khoanThuRepo) {
        this.khoanThuRepo = khoanThuRepo;
    }

    @Override
    public List<KhoanThu> findAll() {
        return khoanThuRepo.findAll();
    }

    @Override
    public Optional<KhoanThu> findById(Integer id) {
        return khoanThuRepo.findById(id);
    }

    @Override
    public KhoanThu save(KhoanThu khoanThu) {
        return khoanThuRepo.save(khoanThu);
    }

    @Override
    public void deleteById(Integer id) {
        khoanThuRepo.deleteById(id);
    }
}