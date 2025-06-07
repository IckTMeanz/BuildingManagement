

package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhau;
import vn.group27.buildingManagement.Entity.HoKhauNhanKhauId;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Repo.HoKhauRepository;
import vn.group27.buildingManagement.Repo.HoKhauNhanKhauRepository;
import vn.group27.buildingManagement.Repo.NhanKhauRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HoKhauService {

    @Autowired
    private HoKhauRepository hoKhauRepository;

    @Autowired
    private NhanKhauRepository nhanKhauRepository;

    @Autowired
    private HoKhauNhanKhauRepository hoKhauNhanKhauRepository;

    public List<HoKhau> getAllHoKhau() {
        return hoKhauRepository.findAll();
    }

    public Optional<HoKhau> getHoKhauById(Integer id) {
        return hoKhauRepository.findById(id);
    }

    public HoKhau createHoKhau(HoKhau hoKhau, Integer chuhoId) {
        NhanKhau chuho = nhanKhauRepository.findById(chuhoId)
                .orElseThrow(() -> new RuntimeException("Chuho not found with id " + chuhoId));
        hoKhau.setChuho(chuho);
        HoKhau savedHoKhau = hoKhauRepository.save(hoKhau);

        // Automatically add chuho to hokhau_nhankhau
        HoKhauNhanKhau hoKhauNhanKhau = new HoKhauNhanKhau();
        hoKhauNhanKhau.setHokhauId(savedHoKhau.getSohokhau());
        hoKhauNhanKhau.setNhankhauId(chuhoId);
        hoKhauNhanKhau.setNgaythemnhankhau(new Date());
        hoKhauNhanKhau.setQuanhevoichuho("Chủ hộ");
        hoKhauNhanKhau.setHokhau(savedHoKhau);
        hoKhauNhanKhau.setNhankhau(chuho);
        hoKhauNhanKhauRepository.save(hoKhauNhanKhau);

        return savedHoKhau;
    }

    public HoKhau updateHoKhau(Integer id, HoKhau hoKhauDetails, Integer chuhoId) {
        HoKhau hoKhau = hoKhauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HoKhau not found with id " + id));
        hoKhau.setSonha(hoKhauDetails.getSonha());
        hoKhau.setDuong(hoKhauDetails.getDuong());
        hoKhau.setPhuong(hoKhauDetails.getPhuong());
        hoKhau.setQuan(hoKhauDetails.getQuan());
        hoKhau.setNgaylamhokhau(hoKhauDetails.getNgaylamhokhau());
        if (chuhoId != null) {
            NhanKhau chuho = nhanKhauRepository.findById(chuhoId)
                    .orElseThrow(() -> new RuntimeException("Chuho not found with id " + chuhoId));
            hoKhau.setChuho(chuho);
        }
        return hoKhauRepository.save(hoKhau);
    }

    public void deleteHoKhau(Integer id) {
        HoKhau hoKhau = hoKhauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("HoKhau not found with id " + id));
        hoKhauRepository.delete(hoKhau);
    }

    public HoKhau addNhanKhauToHoKhau(Integer hokhauId, Integer nhankhauId, String quanhevoichuho) {
        HoKhau hoKhau = hoKhauRepository.findById(hokhauId)
                .orElseThrow(() -> new RuntimeException("HoKhau not found with id " + hokhauId));
        NhanKhau nhanKhau = nhanKhauRepository.findById(nhankhauId)
                .orElseThrow(() -> new RuntimeException("NhanKhau not found with id " + nhankhauId));

        HoKhauNhanKhau hoKhauNhanKhau = new HoKhauNhanKhau();
        hoKhauNhanKhau.setHokhauId(hokhauId);
        hoKhauNhanKhau.setNhankhauId(nhankhauId);
        hoKhauNhanKhau.setNgaythemnhankhau(new Date());
        hoKhauNhanKhau.setQuanhevoichuho(quanhevoichuho);
        hoKhauNhanKhau.setHokhau(hoKhau);
        hoKhauNhanKhau.setNhankhau(nhanKhau);
        hoKhauNhanKhauRepository.save(hoKhauNhanKhau);

        return hoKhau;
    }
    public void removeNhanKhauFromHoKhau(Integer hokhauId, Integer nhankhauId) {
        HoKhauNhanKhauId id = new HoKhauNhanKhauId(hokhauId, nhankhauId);
        HoKhauNhanKhau hknk = hoKhauNhanKhauRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Household-Person link not found"));
        hoKhauNhanKhauRepository.delete(hknk);
    }
}

