package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Repo.NhanKhauRepo;

import java.util.List;

@Service
public class NhanKhauService {
    private NhanKhauRepo nhanKhauRepo;
    @Autowired
    public NhanKhauService(NhanKhauRepo nhanKhauRepo){
        this.nhanKhauRepo=nhanKhauRepo;
    }

    public List<NhanKhau> findAll(){
        return this.nhanKhauRepo.findAll();
    }

    public NhanKhau save(NhanKhau nhanKhau){
        return this.nhanKhauRepo.save(nhanKhau);
    }


    public NhanKhau findById(int id){
        return this.nhanKhauRepo.findById(id);
    }
}
