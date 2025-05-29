package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.NopTien;
import vn.group27.buildingManagement.Repo.NopTienRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class NopTienServiceImpl implements NopTienService {
    private final NopTienRepo nopTienRepo;

    @Autowired
    public NopTienServiceImpl(NopTienRepo nopTienRepo) {
        this.nopTienRepo = nopTienRepo;
    }

    @Override
    public List<NopTien> findAll() {
        return nopTienRepo.findAll();
    }

    @Override
    public Optional<NopTien> findById(Integer id) {
        return nopTienRepo.findById(id);
    }

    @Override
    public NopTien save(NopTien nopTien) {
        return nopTienRepo.save(nopTien);
    }

    @Override
    public void deleteById(Integer id) {
        nopTienRepo.deleteById(id);
    }
}