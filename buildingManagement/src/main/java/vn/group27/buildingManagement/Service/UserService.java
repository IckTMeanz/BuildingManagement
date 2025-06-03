package vn.group27.buildingManagement.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.group27.buildingManagement.Entity.User;

import java.util.List;


public interface UserService extends UserDetailsService {
    public User findByUsername(String name);

    public User save(User u);

    public List<User> findAll();

}
