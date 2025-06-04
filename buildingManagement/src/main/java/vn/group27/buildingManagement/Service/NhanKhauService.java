
package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Repo.NhanKhauRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NhanKhauService {

    @Autowired
    private NhanKhauRepository nhanKhauRepository;

    public List<NhanKhau> getAllNhanKhau() {
        return nhanKhauRepository.findAll();
    }

    public Optional<NhanKhau> getNhanKhauById(Integer id) {
        return nhanKhauRepository.findById(id);
    }

    public NhanKhau createNhanKhau(NhanKhau nhanKhau) {
        return nhanKhauRepository.save(nhanKhau);
    }

    public NhanKhau updateNhanKhau(Integer id, NhanKhau nhanKhauDetails) {
        NhanKhau nhanKhau = nhanKhauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NhanKhau not found with id " + id));
        nhanKhau.setHoten(nhanKhauDetails.getHoten());
        nhanKhau.setNgaysinh(nhanKhauDetails.getNgaysinh());
        nhanKhau.setGioitinh(nhanKhauDetails.getGioitinh());
        nhanKhau.setDantoc(nhanKhauDetails.getDantoc());
        nhanKhau.setTongiao(nhanKhauDetails.getTongiao());
        nhanKhau.setCccd(nhanKhauDetails.getCccd());
        nhanKhau.setNgaycap(nhanKhauDetails.getNgaycap());
        nhanKhau.setNoicap(nhanKhauDetails.getNoicap());
        nhanKhau.setNghenghiep(nhanKhauDetails.getNghenghiep());
        nhanKhau.setGhichu(nhanKhauDetails.getGhichu());
        return nhanKhauRepository.save(nhanKhau);
    }

    public void deleteNhanKhau(Integer id) {
        NhanKhau nhanKhau = nhanKhauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NhanKhau not found with id " + id));
        nhanKhauRepository.delete(nhanKhau);
    }
}
