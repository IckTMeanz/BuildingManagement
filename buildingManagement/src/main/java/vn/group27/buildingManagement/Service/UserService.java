package vn.group27.buildingManagement.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.group27.buildingManagement.Entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService extends UserDetailsService {
    public User findByUsername(String name);

    public User save(User u);
    // Thêm CRUD
    List<User> findAll();
    Optional<User> findById(Integer id);
    void deleteById(Integer id);
}
