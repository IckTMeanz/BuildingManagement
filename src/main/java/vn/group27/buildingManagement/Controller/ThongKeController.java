package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.group27.buildingManagement.DTO.SoLuongHoDaNopVaChuaNopDTO;
import vn.group27.buildingManagement.DTO.TongTienTheoKhoanThuDTO;
import vn.group27.buildingManagement.Service.KhoanThuService;

import java.util.List;

@Controller
public class ThongKeController {

    private final KhoanThuService khoanThuService;

    @Autowired
    public ThongKeController(KhoanThuService khoanThuService) {
        this.khoanThuService = khoanThuService;
    }

//    @GetMapping("/thongke/khoanthu")
//    public String hienThiThongKeKhoanThu(Model model) {
//        List<TongTienTheoKhoanThuDTO> tongTienList = khoanThuService.layTongTienTheoKhoanThu();
//        List<SoLuongHoDaNopVaChuaNopDTO> soLuongHoList = khoanThuService.laySoLuongHoDaNopVaChuaNop();
//
//        System.out.println("Số lượng hộ: " + soLuongHoList.size());
//        System.out.println("Tổng tiền: " + tongTienList.size());
//
//        model.addAttribute("tongTienTheoKhoanThu", tongTienList);
//        model.addAttribute("soLuongHoDaNopVaChuaNop", soLuongHoList);
//
//        return "thongke_khoanthu";  // file templates/thongke.html
//    }
@GetMapping("/thongke")
public String showThongKe(Model model) {
    List<SoLuongHoDaNopVaChuaNopDTO> listSoLuongHo = khoanThuService.laySoLuongHoDaNopVaChuaNop();
    List<TongTienTheoKhoanThuDTO> listTongTien = khoanThuService.layTongTienTheoKhoanThu();


    model.addAttribute("listSoLuongHo", listSoLuongHo);
    model.addAttribute("listTongTien", listTongTien);

    return "thongke";
}
}
