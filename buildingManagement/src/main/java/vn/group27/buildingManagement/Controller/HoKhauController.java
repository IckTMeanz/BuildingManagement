package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.group27.buildingManagement.Entity.HoKhau;

import vn.group27.buildingManagement.Repo.NhanKhauRepo;
import vn.group27.buildingManagement.Service.HoKhauService;
import vn.group27.buildingManagement.Service.NhanKhauService;

import java.util.List;

@Controller

@RequestMapping("/hokhau")
public class HoKhauController {
    private HoKhauService hoKhauService;
    private NhanKhauService nhanKhauService;
    @Autowired

    public HoKhauController(HoKhauService hoKhauService, NhanKhauService nhanKhauService){
        this.hoKhauService=hoKhauService;
        this.nhanKhauService=nhanKhauService;
    }

    @GetMapping("/list")
    public String getAllKT(Model model){
        List<HoKhau> list= this.hoKhauService.findAll();
        model.addAttribute("list", list);
        model.addAttribute("newHoKhau", new HoKhau());
        model.addAttribute(("dsChuHo"), nhanKhauService.findAll());
        return "ListHK";

    }



    @PostMapping("/save")
    public String saveKhoanThu(@ModelAttribute("newHoKhau") HoKhau hk) {
        hoKhauService.save(hk); // hoặc repository.save(kt)
        return "redirect:/hokhau/list";
    }

}
