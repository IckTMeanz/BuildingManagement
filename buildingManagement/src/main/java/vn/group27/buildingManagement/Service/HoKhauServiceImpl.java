package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Repo.HoKhauRepo;

import java.util.List;
import java.util.Optional;

@Service
public class HoKhauServiceImpl implements HoKhauService {

    private final HoKhauRepo hoKhauRepo;

    @Autowired
    public HoKhauServiceImpl(HoKhauRepo hoKhauRepo) {
        this.hoKhauRepo = hoKhauRepo;
    }

    @Override
    public List<HoKhau> findAll() {
        return hoKhauRepo.findAll();
    }

    @Override
    public Optional<HoKhau> findById(Integer id) {
        return hoKhauRepo.findById(id);
    }

    @Override
    public HoKhau save(HoKhau hoKhau) {
        return hoKhauRepo.save(hoKhau);
    }

    @Override
    public void deleteById(Integer id) {
        hoKhauRepo.deleteById(id);
    }
}