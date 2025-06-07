

package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.group27.buildingManagement.Entity.HoKhau;
import vn.group27.buildingManagement.Service.HoKhauService;

import java.util.List;

@RestController
@RequestMapping("/api/hokhau")
public class HoKhauController {

    @Autowired
    private HoKhauService hoKhauService;

    @GetMapping
    public List<HoKhau> getAllHoKhau() {
        return hoKhauService.getAllHoKhau();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HoKhau> getHoKhauById(@PathVariable Integer id) {
        return hoKhauService.getHoKhauById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public HoKhau createHoKhau(@RequestBody HoKhau hoKhau, @RequestParam Integer chuhoId) {
        return hoKhauService.createHoKhau(hoKhau, chuhoId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoKhau> updateHoKhau(@PathVariable Integer id, @RequestBody HoKhau hoKhauDetails, @RequestParam(required = false) Integer chuhoId) {
        return ResponseEntity.ok(hoKhauService.updateHoKhau(id, hoKhauDetails, chuhoId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoKhau(@PathVariable Integer id) {
        hoKhauService.deleteHoKhau(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{hokhauId}/nhankhau/{nhankhauId}")
    public ResponseEntity<HoKhau> addNhanKhauToHoKhau(@PathVariable Integer hokhauId, @PathVariable Integer nhankhauId, @RequestParam String quanhevoichuho) {
        return ResponseEntity.ok(hoKhauService.addNhanKhauToHoKhau(hokhauId, nhankhauId, quanhevoichuho));
    }
    @DeleteMapping("/{hokhauId}/nhankhau/{nhankhauId}")
    public ResponseEntity<Void> removeNhanKhauFromHoKhau(@PathVariable Integer hokhauId, @PathVariable Integer nhankhauId) {
        hoKhauService.removeNhanKhauFromHoKhau(hokhauId, nhankhauId);
        return ResponseEntity.noContent().build();
    }
}
