package vn.group27.buildingManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.group27.buildingManagement.Entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}
