package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Repo.HoKhauRepo;

import java.util.List;

@Service
public class HoKhauService {
    private HoKhauRepo hoKhauRepo;
    @Autowired
    public HoKhauService(HoKhauRepo hoKhauRepo){
        this.hoKhauRepo=hoKhauRepo;
    }

    public List<HoKhau> findAll(){
        return this.hoKhauRepo.findAll();
    }

    public HoKhau save(HoKhau hk){
        return this.hoKhauRepo.save(hk);
    }
}


