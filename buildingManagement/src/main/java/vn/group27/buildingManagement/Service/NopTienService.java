package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.NopTien;
import vn.group27.buildingManagement.Repo.NopTienRepo;

import java.util.List;

@Service
public class NopTienService {
    private NopTienRepo nopTienRepo;
    @Autowired
    public NopTienService(NopTienRepo nopTienRepo){
        this.nopTienRepo=nopTienRepo;
    }

    public List<NopTien> findAll(){
        return this.nopTienRepo.findAll();
    }

    public NopTien findById(int id){
        return this.nopTienRepo.findById(id);
    }
}
