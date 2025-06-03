package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.group27.buildingManagement.Entity.NopTien;
import vn.group27.buildingManagement.Service.NopTienService;

import java.util.List;

@Controller
@RequestMapping("/noptien")
public class NopTienController {
    private NopTienService nopTienService;
    @Autowired
    public NopTienController(NopTienService nopTienService){
        this.nopTienService=nopTienService;
    }
    @GetMapping("/list")

    public String getAllHistory(Model model){
        List<NopTien> listNopTien= this.nopTienService.findAll();
        model.addAttribute("listNopTien", listNopTien);
        return "list_noptien";
    }
}
