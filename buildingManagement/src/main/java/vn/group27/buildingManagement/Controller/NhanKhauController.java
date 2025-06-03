package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Service.HoKhauService;
import vn.group27.buildingManagement.Service.NhanKhauService;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/nhankhau")
public class NhanKhauController {
    private NhanKhauService nhanKhauService;
    @Autowired

    public NhanKhauController(NhanKhauService nhanKhauService)
    {
        this.nhanKhauService= nhanKhauService;
    }

    @GetMapping("/list")
    public String getAllKT(Model model){
        List<NhanKhau> list= this.nhanKhauService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("newNhanKhau", new NhanKhau());
        return "ListNK";

    }
//    @GetMapping("/list")
//    public List<NhanKhau> getAllKT(Model model){
//        return this.nhanKhauService.findAll();
//
//
//    }
    @PostMapping("/save")
    public String saveKhoanThu(@ModelAttribute("newNhanKhau") NhanKhau hk) {
        nhanKhauService.save(hk); // hoặc repository.save(kt)
        return "redirect:/nhankhau/list";
    }


}
