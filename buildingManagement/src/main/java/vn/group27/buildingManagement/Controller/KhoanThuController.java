package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.group27.buildingManagement.Entity.KhoanThu;
import vn.group27.buildingManagement.Service.KhoanThuService;

import java.util.List;

@Controller
@RequestMapping("/khoanthu")
public class KhoanThuController {
    private KhoanThuService kts;
    @Autowired
    public KhoanThuController(KhoanThuService kts){
        this.kts=kts;
    }

    @GetMapping("/list")
    public String getAllKT(Model model){
        List<KhoanThu> list= kts.findAll();
        model.addAttribute("list", list);
        model.addAttribute("newKhoanThu", new KhoanThu());
        return "listKT";

    }
    @PostMapping("/save")
    public String saveKhoanThu(@ModelAttribute("newKhoanThu") KhoanThu kt) {
        kts.save(kt); // hoặc repository.save(kt)
        return "redirect:/khoanthu/list";
    }


//    @PostMapping("/save")
//    public String saveKhoanThu(@Valid @ModelAttribute("newKhoanThu") KhoanThu kt,
//                               BindingResult result,
//                               Model model) {
//        if (result.hasErrors()) {
//            model.addAttribute("list", kts.findAll());
//            return "listKT";  // trả lại trang form để hiển thị lỗi
//        }
//        kts.save(kt);
//        return "redirect:/khoanthu/list";
//    }

    // API xoá khoản thu theo id
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteKhoanThu(@PathVariable("id") Integer id) {
        try {
            kts.DeleteByID(id); // gọi service để xoá
            return ResponseEntity.ok("Xoá khoản thu thành công");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi xoá khoản thu: " + e.getMessage());
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteKhoanThu2(@PathVariable("id") Integer id) {

        kts.DeleteByID(id);
        return "redirect:/khoanthu/list";
    }







}
