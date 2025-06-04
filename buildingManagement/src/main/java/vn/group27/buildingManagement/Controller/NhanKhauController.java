
package vn.group27.buildingManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.group27.buildingManagement.Entity.NhanKhau;
import vn.group27.buildingManagement.Service.NhanKhauService;

import java.util.List;

@RestController
@RequestMapping("/api/nhankhau")
public class NhanKhauController {

    @Autowired
    private NhanKhauService nhanKhauService;

    @GetMapping
    public List<NhanKhau> getAllNhanKhau() {
        return nhanKhauService.getAllNhanKhau();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NhanKhau> getNhanKhauById(@PathVariable Integer id) {
        return nhanKhauService.getNhanKhauById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NhanKhau createNhanKhau(@RequestBody NhanKhau nhanKhau) {
        return nhanKhauService.createNhanKhau(nhanKhau);
    }


    @PutMapping("/{id}")
    public ResponseEntity<NhanKhau> updateNhanKhau(@PathVariable Integer id, @RequestBody NhanKhau nhanKhauDetails) {
        try {
            NhanKhau updatedNhanKhau = nhanKhauService.updateNhanKhau(id, nhanKhauDetails);
            return ResponseEntity.ok(updatedNhanKhau);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanKhau(@PathVariable Integer id) {
        try {
            nhanKhauService.deleteNhanKhau(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
