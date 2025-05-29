package vn.group27.buildingManagement.Service;

import vn.group27.buildingManagement.Entity.TamTruTamVang;
import vn.group27.buildingManagement.Repo.TamTruTamVangRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class TamTruTamVangServiceImpl implements TamTruTamVangService {
    private final TamTruTamVangRepo tamTruTamVangRepo;

    @Autowired
    public TamTruTamVangServiceImpl(TamTruTamVangRepo tamTruTamVangRepo) {
        this.tamTruTamVangRepo = tamTruTamVangRepo;
    }

    @Override
    public List<TamTruTamVang> findAll() {
        return tamTruTamVangRepo.findAll();
    }

    @Override
    public Optional<TamTruTamVang> findById(Integer id) {
        return tamTruTamVangRepo.findById(id);
    }

    @Override
    public TamTruTamVang save(TamTruTamVang tamTruTamVang) {
        return tamTruTamVangRepo.save(tamTruTamVang);
    }

    @Override
    public void deleteById(Integer id) {
        tamTruTamVangRepo.deleteById(id);
    }
}