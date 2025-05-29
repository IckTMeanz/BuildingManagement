package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.group27.buildingManagement.Entity.User;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByUsername(String username);
}