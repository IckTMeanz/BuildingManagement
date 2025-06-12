package vn.group27.buildingManagement.Controller;



import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Entity.PhuongTien;
import vn.group27.buildingManagement.Repo.HoKhauRepo;
import vn.group27.buildingManagement.Repo.PhuongTienRepo;

import java.util.List;

@Controller
@RequestMapping("/phuongtien")
@RequiredArgsConstructor
public class PhuongTienController {

    private final PhuongTienRepo phuongTienRepo;
    private final HoKhauRepo hoKhauRepo;

    @GetMapping("/list")
    public String listPhuongTien(Model model) {
        model.addAttribute("list", phuongTienRepo.findAll());
        model.addAttribute("newPhuongTien", new PhuongTien());
        model.addAttribute("dsHoKhau", hoKhauRepo.findAll());
        return "listPT";
    }

//    @PostMapping("/save")
//    public String savePhuongTien(@ModelAttribute("newPhuongTien") PhuongTien pt) {
//        phuongTienRepo.save(pt);
//        return "redirect:/phuongtien/list";
//    }

    @PostMapping("/save")
    public String savePhuongTien(@ModelAttribute("newPhuongTien") PhuongTien pt) {
        // Lấy id hokhau từ pt.getHokhau().getSohokhau() rồi fetch HoKhau thực từ DB
        Integer soHoKhau = pt.getHokhau().getSohokhau();
        HoKhau hk = hoKhauRepo.findById(soHoKhau).orElse(null);
        pt.setHokhau(hk);
        pt.setTrangthai("Chờ duyệt");
        phuongTienRepo.save(pt);
        return "redirect:/phuongtien/list";
    }



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        phuongTienRepo.deleteById(id);
        return "redirect:/phuongtien/list";
    }

    @GetMapping("/duyet")
    @PreAuthorize("hasRole('ADMIN')")
    public String duyetPhuongTien(Model model) {
        List<PhuongTien> choDuyet = phuongTienRepo.findByTrangthai("Chờ duyệt");
        model.addAttribute("dsChoDuyet", choDuyet);
        return "duyetPT";
    }

    @PostMapping("/approve/{id}")
    public String approve(@PathVariable("id") String id) {
        PhuongTien pt = phuongTienRepo.findById(id).orElseThrow();
        pt.setTrangthai("Đã duyệt");
        phuongTienRepo.save(pt);
        return "redirect:/phuongtien/duyet";
    }

    @PostMapping("/reject/{id}")
    public String reject(@PathVariable("id") String id) {
        PhuongTien pt = phuongTienRepo.findById(id).orElseThrow();
        pt.setTrangthai("Từ chối");
        phuongTienRepo.save(pt);
        return "redirect:/phuongtien/duyet";
    }

}
