package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Repo.NhanKhauRepo;

import java.util.List;
import java.util.Optional;

@Service
public class NhanKhauServiceImpl implements NhanKhauService {

    private final NhanKhauRepo nhanKhauRepo;

    @Autowired
    public NhanKhauServiceImpl(NhanKhauRepo nhanKhauRepo) {
        this.nhanKhauRepo = nhanKhauRepo;
    }

    @Override
    public List<NhanKhau> findAll() {
        return nhanKhauRepo.findAll();
    }

    @Override
    public Optional<NhanKhau> findById(Integer id) {
        return nhanKhauRepo.findById(id);
    }

    @Override
    public NhanKhau save(NhanKhau nhanKhau) {
        return nhanKhauRepo.save(nhanKhau);
    }

    @Override
    public void deleteById(Integer id) {
        nhanKhauRepo.deleteById(id);
    }
}