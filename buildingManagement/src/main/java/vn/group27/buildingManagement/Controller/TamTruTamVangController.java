package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.group27.buildingManagement.Entity.TamTruTamVang;
import vn.group27.buildingManagement.Repo.NhanKhauRepository;
import vn.group27.buildingManagement.Repo.TamTruTamVangRepo;
import vn.group27.buildingManagement.Service.NhanKhauService;

@Controller
@RequestMapping("/tamtrutamvang")
public class TamTruTamVangController {

    @Autowired
    private TamTruTamVangRepo repository;

    @Autowired
    private NhanKhauRepository nhanKhauRepository;

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("tamtrutamvang", new TamTruTamVang());
        model.addAttribute("dsNhanKhau", nhanKhauRepository.findAll());
        return "tamtrutamvang";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TamTruTamVang tttv) {
        repository.save(tttv);
        return "redirect:/tamtrutamvang/add?success";
    }
}

