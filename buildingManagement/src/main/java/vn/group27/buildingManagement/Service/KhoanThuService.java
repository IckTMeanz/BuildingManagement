package vn.group27.buildingManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.group27.buildingManagement.DTO.SoLuongHoDaNopVaChuaNopDTO;
import vn.group27.buildingManagement.DTO.TongTienTheoKhoanThuDTO;
import vn.group27.buildingManagement.Entity.KhoanThu;
import vn.group27.buildingManagement.Repo.HoKhauRepo;
import vn.group27.buildingManagement.Repo.KhoanThuRepo;

import java.util.List;

@Service
public class KhoanThuService {
    private KhoanThuRepo khoanThuRepo;
    @Autowired
    public KhoanThuService(KhoanThuRepo khoanThuRepo){
        this.khoanThuRepo=khoanThuRepo;
    }

    public List<KhoanThu> findAll(){
        return khoanThuRepo.findAll();
    }
    public KhoanThu save(KhoanThu khoanThu){
        return this.khoanThuRepo.save(khoanThu);
    }


    public void DeleteByID(int id){
        this.khoanThuRepo.deleteById(id);
    }
    @Autowired
    private HoKhauRepo hoKhauRepo;

    public List<TongTienTheoKhoanThuDTO> layTongTienTheoKhoanThu() {
        return khoanThuRepo.getTongTienTheoKhoanThu();
    }

    public List<SoLuongHoDaNopVaChuaNopDTO> laySoLuongHoDaNopVaChuaNop() {
        Long tongSoHoLong = hoKhauRepo.count(); // Lấy giá trị Long
        Integer tongSoHo = tongSoHoLong.intValue(); // Ép kiểu sang Integer
        if (tongSoHoLong > Integer.MAX_VALUE) {
            throw new IllegalStateException("Tổng số hộ vượt quá giới hạn của Integer");
        }

        List<SoLuongHoDaNopVaChuaNopDTO> list = khoanThuRepo.getSoLuongHoDaNop();

        // Tính số hộ chưa nộp = tổng hộ - số hộ đã nộp
        for (SoLuongHoDaNopVaChuaNopDTO dto : list) {
            dto.setSoHoChuaNop(tongSoHo - dto.getSoHoDaNop());
        }
        return list;
    }

}
