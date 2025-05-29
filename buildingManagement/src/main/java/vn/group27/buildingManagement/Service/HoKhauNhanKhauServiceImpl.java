package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.HoKhauNhanKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhauId;
import vn.group27.buildingManagement.Repo.HoKhauNhanKhauRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class HoKhauNhanKhauServiceImpl implements HoKhauNhanKhauService {
    private final HoKhauNhanKhauRepo hoKhauNhanKhauRepo;

    @Autowired
    public HoKhauNhanKhauServiceImpl(HoKhauNhanKhauRepo hoKhauNhanKhauRepo) {
        this.hoKhauNhanKhauRepo = hoKhauNhanKhauRepo;
    }

    @Override
    public List<HoKhauNhanKhau> findAll() {
        return hoKhauNhanKhauRepo.findAll();
    }

    @Override
    public Optional<HoKhauNhanKhau> findById(HoKhauNhanKhauId id) {
        return hoKhauNhanKhauRepo.findById(id);
    }

    @Override
    public HoKhauNhanKhau save(HoKhauNhanKhau hoKhauNhanKhau) {
        return hoKhauNhanKhauRepo.save(hoKhauNhanKhau);
    }

    @Override
    public void deleteById(HoKhauNhanKhauId id) {
        hoKhauNhanKhauRepo.deleteById(id);
    }
}